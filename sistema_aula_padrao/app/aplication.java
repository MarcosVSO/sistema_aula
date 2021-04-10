package app;

import ctrl.AlunoCtrl;
import ctrl.CursoCtrl;
import ctrl.DisciplinaCtrl;
import ctrl.OfertaCtrl;
import ctrl.PessoaCtrl;
import ctrl.ProfessorCtrl;
import ctrl.exception.AlunoException;

public class aplication {

	public static void main(String[] args) throws AlunoException {

		TesteApp testeApp = new TesteApp();
		
		//testeApp.testeCrudDisciplina(new DisciplinaCtrl());
		//testeApp.testeCrudPessoa(new PessoaCtrl());
		//testeApp.testeCrudProfessor(new ProfessorCtrl(), new PessoaCtrl());
		//testeApp.testeCrudOferta(new OfertaCtrl(), new DisciplinaCtrl(), new ProfessorCtrl());
		//testeApp.testeCrudCurso(new CursoCtrl());
		testeApp.testeCrudAluno(new AlunoCtrl());
	}
	
	

}
