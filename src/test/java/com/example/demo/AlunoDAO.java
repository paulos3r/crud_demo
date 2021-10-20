package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public List<Aluno> list(){
        List<Aluno> alunos = new ArrayList<>();
            //chama a conexão
        try(Connection conn = ConnectionFactory.getConnection()) {
            //passa a consulta sql para a variavel
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM aluno");
            //execulta a consulta
            ResultSet result = prep.executeQuery();

            //vai verificar se possui registro  next retorna boolean
            while(result.next()){
                //chamando o contrutor e pagando os valores da consulta no ResultSet
                Aluno aluno = new Aluno(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getInt("idade"),
                        result.getString("estado")
                );
                /*pegando o resultado e inserindo na lista*/
                alunos.add(aluno);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return alunos;
    }

    public Aluno getById(int id){
        Aluno aluno = new Aluno();

        try(Connection conn = ConnectionFactory.getConnection()){
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM aluno WHERE id = ?");
            prep.setInt(1, id);

            ResultSet result = prep.executeQuery();

            if(result.next()){
                aluno.setId(result.getInt("id"));
                aluno.setNome(result.getString("nome"));
                aluno.setIdade(result.getInt("idade"));
                aluno.setEstado(result.getString("estado"));
            }
        }catch (Exception e){
            System.out.println("erro na consulta" + e.getMessage());
            e.printStackTrace();
        }
        return aluno;
    }

    public void create(Aluno aluno){
        try(Connection conn = ConnectionFactory.getConnection()){
            //sql vou passar em variavel
            String sql = "INSERT INTO aluno(nome,idade,estado) values (?,?,?)";
            //passando sql e preparando sql
            PreparedStatement prep = conn.prepareStatement(sql);

            // setando as configurações nos pontos de ?
            prep.setString(1,aluno.getNome());
            prep.setInt(2,aluno.getIdade());
            prep.setString(3,aluno.getEstado());

            //retorna o numero de linhas afetadas
            int linhaAfetada = prep.executeUpdate();

            System.out.println("tudo ok : " + linhaAfetada + " linha");
        }catch (Exception e){
            System.out.println(" Erro na criação " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "DELETE FROM aluno WHERE id = ?";
            PreparedStatement prep = conn.prepareStatement(sql);

            prep.setInt(1,id);

            int linhaAfetada = prep.executeUpdate();

            System.out.println("linha afetada : " + linhaAfetada);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(Aluno aluno){
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";
            PreparedStatement prep = conn.prepareStatement(sql);

            prep.setString(1, aluno.getNome());
            prep.setInt(2, aluno.getIdade());
            prep.setString(3,aluno.getEstado());

            prep.setInt(4,aluno.getId());

            int linhaAfetada = prep.executeUpdate();

            System.out.println("Linhas afetadas" + linhaAfetada);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
