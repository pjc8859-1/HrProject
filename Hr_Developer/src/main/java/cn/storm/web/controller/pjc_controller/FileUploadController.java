package cn.storm.web.controller.pjc_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/upload")
public class FileUploadController {
	@RequestMapping("up.do")
	public ModelAndView fileupload(MultipartFile file)
	{
		String filename = file.getOriginalFilename();
		System.out.println(filename);
		return null;
	}

}
