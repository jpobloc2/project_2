package com.ers.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpController {

	void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

	void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

	void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

	void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

}
