package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.DB;
import ctrl.exception.AlunoException;
import model.entities.Aluno;
import model.entities.Curso;
import model.entities.Pessoa;

public class AlunoDAO {
	//Inserir Aluno
	public Aluno inserir(Aluno aluno) throws AlunoException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement("INSERT INTO tb_aluno " + "(dt_inicio,ativo,id_pessoa,id_curso)" + "VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, new Date(aluno.getDtInicio().getTime()));
			st.setBoolean(2, aluno.getAtivo());
			Pessoa pessoa = aluno.getPessoa();
			st.setInt(3,pessoa.getIdPessoa());
			Curso curso = aluno.getCurso();
			st.setInt(4,curso.getIdCurso());
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					curso.setIdCurso(id);
				}
			}
		}
		catch (SQLException e){
			throw new AlunoException(e.getMessage());
		}
		return aluno;
	}
	
	//READS alunos
	public List<Aluno> buscaTodos() throws AlunoException {
		ResultSet rs = null;
		PreparedStatement st = null;
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement("SELECT id_aluno,dt_inicio,ativo,id_pessoa,id_curso FROM tb_aluno ORDER BY id_pessoa" ,Statement.RETURN_GENERATED_KEYS);
			rs = st.executeQuery();
			while (rs.next()) {
				Aluno aluno  = new Aluno();
				aluno.setAtivo(rs.getBoolean("ativo"));
				aluno.setCurso(new Curso(rs.getInt("id_curso"),null));
				aluno.setDtInicio(rs.getDate("dt_inicio"));
				aluno.setIdAluno(rs.getInt("id_aluno"));
				aluno.setPessoa(new Pessoa(rs.getInt("id_pessoa"),null,null,null));
				alunos.add(aluno);
			}

		} catch (SQLException e) {
			throw new AlunoException(e.getMessage());

		}

		return alunos;
	}
	
	public Aluno buscaPorId(Integer id) throws AlunoException{
		Aluno aluno = new Aluno();
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			String query = "SELECT dt_inicio,ativo,id_pessoa,id_curso FROM tb_aluno WHERE id_aluno = ?";
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1,id);
			rs = st.executeQuery();
			while (rs.next()) {
				aluno.setAtivo(rs.getBoolean("ativo"));
				aluno.setCurso(new Curso(rs.getInt("id_curso"),null));
				aluno.setDtInicio(rs.getDate("dt_inicio"));
				aluno.setIdAluno(rs.getInt("id_aluno"));
				aluno.setPessoa(new Pessoa(rs.getInt("id_pessoa"),null,null,null));
			}
		}
		catch(SQLException e) {
			throw new AlunoException(e.getMessage());
		}
		return aluno;
	}
	
	//Alterar
	public Aluno alterar(Aluno aluno) throws AlunoException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			String query = "UPDATE tb_curso SET dt_inicio = ?, ativo = ?, id_pessoa = ?, id_curso = ? WHERE id_aluno = ? ; ";
			st = (PreparedStatement) conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			st.setDate(1,new Date(aluno.getDtInicio().getTime()));
			st.setBoolean(2,aluno.getAtivo());
			st.setInt(3, aluno.getPessoa().getIdPessoa());
			st.setInt(4, aluno.getCurso().getIdCurso());
			st.setInt(5, aluno.getIdAluno());
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);
		} catch (SQLException e) {
			throw new AlunoException(e.getMessage());
		}
		return aluno;
	}
	
	//Excluir
	public void excluir(Integer id) throws AlunoException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			
			String query = " DELETE FROM tb_aluno WHERE id_aluno = ? ; ";
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);

		} catch (SQLException e) {
			throw new AlunoException(e.getMessage());
		}
	}
	
}
