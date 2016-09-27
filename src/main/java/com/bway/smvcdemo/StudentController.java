package com.bway.smvcdemo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.smvcdemo.daos.StudentDao;
import com.bway.smvcdemo.models.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentForm(Model model, HttpSession session) {

		if (StringUtils.isEmpty(session.getAttribute("username"))) {
			return "login";
		}

		model.addAttribute("student", new Student());
		return "studentForm";
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student, Model model, HttpSession session) {

		if (StringUtils.isEmpty(session.getAttribute("username"))) {

			return "redirect:/login";
		}

		studentDao.insert(student);
		model.addAttribute("studentList", studentDao.getAll());

		return "listStudent";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)

	public String deleteStudent(@PathVariable("id") Long id, Model model, HttpSession session) {

		if (StringUtils.isEmpty(session.getAttribute("username"))) {

			return "redirect:/login";
		}

		studentDao.delete(id);
		model.addAttribute("studentList", studentDao.getAll());

		return "listStudent";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)

	public String editStudent(@PathVariable("id") Long id, Model model, HttpSession session) {

		if (StringUtils.isEmpty(session.getAttribute("username"))) {
			return "login";
		}

		model.addAttribute("student", studentDao.get(id));

		return "editStudent";
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)

	public String updateStudent(@ModelAttribute Student student, Model model, HttpSession session) {

		if (StringUtils.isEmpty(session.getAttribute("username"))) {

			return "redirect:/login";
		}
		studentDao.inserUpdate(student);
		model.addAttribute("studentList", studentDao.getAll());

		return "listStudent";
	}

}
