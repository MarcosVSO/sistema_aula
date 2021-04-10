package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.DB;
import ctrl.exception.CursoException;
import model.entities.Curso;

public class CursoDAO {
	
	public Curso inserir(Curso curso) throws CursoException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement(
					"INSERT INTO tb_curso " + "(nm_curso)" + "VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, curso.getNmCurso());
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
			throw new CursoException(e.getMessage());
		}
		return curso;
	}
	
	public List<Curso> buscaTodos() throws CursoException {
		List<Curso> cursos = new ArrayList<Curso>();
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement("SELECT id_curso,nm_curso FROM tb_curso" ,Statement.RETURN_GENERATED_KEYS);
			rs = st.executeQuery();
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setIdCurso(rs.getInt("id_curso"));
				curso.setNmCurso(rs.getString("nm_curso"));
				cursos.add(curso);
			}
		}
		catch (SQLException e){
			throw new CursoException(e.getMessage());
		}
		return  cursos;
	}
	
	public Curso buscaPorId(Integer id) throws CursoException{
		Curso curso = new Curso();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement("SELECT id_curso,nm_curso FROM tb_curso WHERE id_curso = ?" ,Statement.RETURN_GENERATED_KEYS);
			st.setInt(1,id);
			rs = st.executeQuery();
			if (rs.next()) {
				curso.setIdCurso(rs.getInt("id_curso"));
				curso.setNmCurso(rs.getString("nm_curso"));
			}
		}catch(SQLException e) {
			throw new CursoException(e.getMessage());
		}
		return curso;
	}
	
	public Curso alterar(Curso curso) throws CursoException{
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			st = (PreparedStatement) conn.prepareStatement("UPDATE tb_curso SET nm_curso = ? WHERE id_curso = ?" ,Statement.RETURN_GENERATED_KEYS);
			st.setString(1, curso.getNmCurso());
			st.setInt(2, curso.getIdCurso());
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);
		} catch (SQLException e) {
			throw new CursoException(e.getMessage());
		}
		return curso;
	}
	
	public void excluir(Integer id) throws CursoException {
		PreparedStatement st = null;
		try {
			Connection conn = DB.getConnection();
			
			String query = " DELETE FROM tb_curso WHERE id_curso = ? ; ";
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas alteradas: " + rowsAffected);

		} catch (SQLException e) {
			throw new CursoException(e.getMessage());
		}
		
	}
}
