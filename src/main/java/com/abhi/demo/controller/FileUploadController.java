package com.abhi.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileUploadController {

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<String> uploadFlexibleFiles(@RequestPart("metadata") FileMetadataDto metadata,
			@RequestPart(value = "files", required = false) MultipartFile[] files) {

		List<String> fileNames = new ArrayList<>();

		if (metadata != null) {
			System.out.println("Uploaded By   : " + metadata.getUploadedBy());
			System.out.println("Document Type : " + metadata.getDocumentType());
			System.out.println("Comments      : " + metadata.getComments());
			System.out.println("----------------------------");
		}

		if (files != null && files.length > 0) {
			for (MultipartFile file : files) {
				if (file != null && !file.isEmpty()) {
					fileNames.add(file.getOriginalFilename());
					System.out.println("Uploaded file: " + file.getOriginalFilename());
				}
			}
		}

		return fileNames;
	}

	/*
	 * @PostMapping("/upload") public String uploadFile(@RequestParam("file")
	 * MultipartFile file) { // Get file details String fileName =
	 * file.getOriginalFilename(); String contentType = file.getContentType(); long
	 * fileSize = file.getSize();
	 * 
	 * // Add backend parameters String uploadedBy = "SystemUser"; LocalDateTime
	 * uploadTime = LocalDateTime.now();
	 * 
	 * // Print everything on console
	 * System.out.println("=== File Upload Info ===");
	 * System.out.println("File Name     : " + fileName);
	 * System.out.println("Content Type  : " + contentType);
	 * System.out.println("File Size     : " + fileSize + " bytes");
	 * System.out.println("Uploaded By   : " + uploadedBy);
	 * System.out.println("Upload Time   : " + uploadTime);
	 * System.out.println("========================");
	 * 
	 * return "File uploaded successfully."; }
	 */

	/*
	 * @PostMapping("/upload") public List<String>
	 * uploadFlexibleFiles(@RequestParam(value = "files", required = false)
	 * MultipartFile[] files) {
	 * 
	 * List<String> fileNames = new ArrayList<>();
	 * 
	 * if (files == null || files.length == 0) {
	 * System.out.println("No files uploaded."); return new ArrayList<>(); } else {
	 * for (MultipartFile file : files) { if (file != null && !file.isEmpty()) {
	 * String fileName = file.getOriginalFilename(); String contentType =
	 * file.getContentType(); long fileSize = file.getSize();
	 * 
	 * String uploadedBy = "SystemUser"; LocalDateTime uploadTime =
	 * LocalDateTime.now();
	 * 
	 * // Add to list fileNames.add(fileName);
	 * 
	 * // Print individual file details System.out.println("File Name     : " +
	 * fileName); System.out.println("Content Type  : " + contentType);
	 * System.out.println("File Size     : " + fileSize + " bytes");
	 * System.out.println("Uploaded By   : " + uploadedBy);
	 * System.out.println("Upload Time   : " + uploadTime);
	 * System.out.println("----------------------------"); } else {
	 * System.out.println("Empty or null file received."); } } }
	 * 
	 * // Print the list of file names
	 * System.out.println("List of Uploaded File Names: " + fileNames);
	 * System.out.println("=== Upload Handling Complete ===");
	 * 
	 * return fileNames; // ✅ return the list (not a string) }
	 */

}
