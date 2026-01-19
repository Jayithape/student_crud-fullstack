import axios from "axios";

const BASE_URL = "http://localhost:8080/student";

export const addStudent = (student) =>
  axios.post(`${BASE_URL}/addstudent`, student);

export const getAllStudents = () =>
  axios.get(`${BASE_URL}/allstudent`);

export const deleteStudent = (id) =>
  axios.delete(`${BASE_URL}/delete/${id}`);

export const updateStudent = (id, student) =>
  axios.put(`${BASE_URL}/update/${id}`, student);
