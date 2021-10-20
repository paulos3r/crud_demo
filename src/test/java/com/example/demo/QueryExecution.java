package com.example.demo;

import java.sql.SQLException;
import java.util.List;

public class QueryExecution {
	public static void main(String[] args) throws SQLException {
		//INSTANCIA
		AlunoDAO alunoDAO = new AlunoDAO();

		//--------LISTANDO----------------
		/*List<Aluno> alunos = alunoDAO.list();

		alunos.stream().forEach(aluno -> System.out.println(aluno.getId() + " " + aluno.getNome()));*/

		//----------BUSCA-----------------
		/*Aluno aluno = alunoDAO.getById(2);
		System.out.println(aluno.getId() + " | " + aluno.getNome());*/

		//----------CRIANDO----------------
		/*Aluno aluno = new Aluno(
				"Tulho",
				45,
				"SP"
		);
		alunoDAO.create(aluno);*/

		//-----------DELETANDO-------------
		/*alunoDAO.delete(4);
		* */

		//---------ATUALIZANDO--------------
		/*Aluno alunoAtualizar = alunoDAO.getById(2);
		alunoAtualizar.setNome("Fernando");
		alunoAtualizar.setIdade(54);
		alunoAtualizar.setEstado("AM");
		alunoDAO.update(alunoAtualizar);*/

	}
}
