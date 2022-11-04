package View;

import java.sql.*;

import Model.Conexao;
//import Model.Empresa;
//import Model.EmpresaDAO;
//import Model.Carro;
//import Model.CarroDAO;
//import Model.Motorista;
//import Model.Usuario;
//import Model.UsuarioDAO;
//import Model.MotoristaDAO;

public class Teste {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();

		/*Usuario usuario = new Usuario();
		usuario.setNome("Vinicius de Oliveira");
		usuario.setCPF(526764518);
		usuario.setTelefone("(11) 96630-9946");
		usuario.setDataNascimento("15-05-2003");
		usuario.setEmail("vini@gmail.com");
		usuario.setLogin("Vini");
		usuario.setRG(575331641);
		usuario.setSenha("1234");
		usuario.setSetor("Administrativo");
		usuario.setRM(1);
		
		UsuarioDAO udao = new UsuarioDAO(con);
		//System.out.println(udao.inserir(usuario));
		//System.out.println(udao.alterar(usuario));
		//System.out.println(udao.excluir(usuario));
		//System.out.println(udao.listarTodos());*/
		
		/*Motorista motorista = new Motorista();
		motorista.setNome("Vinicius de Oleira");
		motorista.setCPF(526764518);
		motorista.setTelefone("(11) 96630-9946");
		motorista.setDataNascimento("15-05-2003");
		motorista.setEmail("vinioliveira@gmail.com");
		motorista.setRG(575331641);
		motorista.setNumeroHabilitacao(123456789);
		motorista.setCategoriaHabilitacao("A");
		motorista.setDataExpedicao("24-06-2022");
		
		MotoristaDAO mdao = new MotoristaDAO(con);
		//System.out.println(mdao.inserir(motorista));
		//System.out.println(mdao.alterar(motorista));
		//System.out.println(mdao.excluir(motorista));
		//System.out.println(mdao.listarTodos());*/
		
		/*Carro carro = new Carro();
		carro.setMarca("Renault");
		carro.setModelo("Kwid");
		carro.setAno(2020);
		carro.setKmPorLitro(11);
		carro.setPlaca("DGS1234");
		
		CarroDAO cdao = new CarroDAO(con);
		System.out.println(cdao.inserir(carro));
		//System.out.println(cdao.alterar(carro));
		//System.out.println(cdao.excluir(carro));
		//System.out.println(cdao.listarTodos());*/
		
		/*Empresa empresa = new Empresa();
		empresa.setCnpj(456789);
		empresa.setEndereco("Rua do Alfineiros 123");
		empresa.setNome("Empresa de TI");
		empresa.setQuantidadeFuncionarios(250);
		empresa.setTelefone("(11) 99194-3486");
		
		EmpresaDAO edao = new EmpresaDAO(con);
		//System.out.println(edao.inserir(empresa));
		//System.out.println(edao.alterar(empresa));
		//System.out.println(edao.excluir(empresa));
		System.out.println(edao.listarTodos());*/
		
		Conexao.fecharConexao(con);

	}

}
