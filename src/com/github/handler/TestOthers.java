package com.github.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class TestOthers {

	@ResponseBody
	@RequestMapping("/testHttpMessageConvert")
	public String testHttpMessageConvert(@RequestBody String body) {
		System.out.println(body);
		return "helloWorld" + new Date();
	}

	@RequestMapping("testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession httpSession) throws IOException {
		byte[] body = null;
		ServletContext servletContext = httpSession.getServletContext();
		InputStream inputStream = servletContext.getResourceAsStream("/files/abc.txt");
		body = new byte[inputStream.available()];
		inputStream.read(body);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");

		HttpStatus status = HttpStatus.OK;
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, status);
		return responseEntity;
	}

	/*@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file)
			throws IOException {
		System.out.println(desc + "-------" + file.getOriginalFilename() + "------" + file.getSize() + "-------"
				+ file.getInputStream());
		return "success";
	}*/
	
	@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc, 
			@RequestParam("file") MultipartFile file) throws IOException{
		System.out.println("desc: " + desc);
		System.out.println("OriginalFilename: " + file.getOriginalFilename());
		System.out.println("InputStream: " + file.getInputStream());
		System.out.println("Size: " + file.getSize());
		return "success";
	}

}
