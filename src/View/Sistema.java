package View;

import javax.swing.JOptionPane;

import Controller.CarroController;
import Controller.EmpresaController;
import Controller.MotoristaController;
import Controller.UsuarioController;

public class Sistema {
	
	public static void main(String[] args) {
		
		String escolha = "sim", aux, setor, login,senha, nome, email, dataNascimento, telefone, RG, cpf, cnpj, endereco, marca, modelo, placa, numero_habilitacao, categoria_habilitacao, data_expedicao;
		int opcaoAcao, opcaoArea, qtd_funcionarios, ano, km_por_litro;
		
		UsuarioController usuario = new UsuarioController();
		EmpresaController empresa = new EmpresaController();
		CarroController carro = new CarroController();
		MotoristaController motorista = new MotoristaController();
		
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Escolha a ação que deseja fazer:\n(1) Cadastrar\n(2) Alterar\n(3) Excluir\n(4) Listar Todos");
				opcaoAcao = Integer.parseInt(aux);
				switch (opcaoAcao) {
				case 1: {
					aux = JOptionPane.showInputDialog("O que deseja inserir?\n(1) Usuario\n(2) Empresa\n(3) Carro\n(4) Motorista");
					opcaoArea = Integer.parseInt(aux);
					switch (opcaoArea) {
					case 1:{
						nome = JOptionPane.showInputDialog("Digite o Nome:");
						telefone = JOptionPane.showInputDialog("Digite o telefone");
						dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento");
						email = JOptionPane.showInputDialog("Digite o email");
						cpf = JOptionPane.showInputDialog("Digite o CPF");
						RG = JOptionPane.showInputDialog("Digite o RG");
						setor = JOptionPane.showInputDialog("Digite o setor");
						login = JOptionPane.showInputDialog("Digite o login");
						senha = JOptionPane.showInputDialog("Digite a senha");
						
						JOptionPane.showMessageDialog(null, usuario.insereUsuario(setor, login, senha, nome, email, dataNascimento, telefone, RG, cpf));
						break;
					}
					case 2: {
						nome = JOptionPane.showInputDialog("Digite o Nome:");
						endereco = JOptionPane.showInputDialog("Digite o Endereço:");
						cnpj = JOptionPane.showInputDialog("Digite o CNPJ");
						telefone = JOptionPane.showInputDialog("Digite o telefone");
						aux = JOptionPane.showInputDialog("Digite a quantidade de funcionários");
						qtd_funcionarios = Integer.parseInt(aux);
						
						JOptionPane.showMessageDialog(null, empresa.insereEmpresa(nome, endereco, cnpj, qtd_funcionarios, telefone));
						break;
					}
					case 3: {
						marca = JOptionPane.showInputDialog("Digite a Marca:");
						modelo = JOptionPane.showInputDialog("Digite o modelo:");
						aux = JOptionPane.showInputDialog("Digite o ano:");
						ano = Integer.parseInt(aux);
						placa = JOptionPane.showInputDialog("Digite a placa:");
						aux = JOptionPane.showInputDialog("Digite a kilometragem por litro:");
						km_por_litro = Integer.parseInt(aux);
						
						JOptionPane.showMessageDialog(null, carro.insereCarro(marca, modelo, ano, km_por_litro, placa));
						break;
					}
					case 4: {
						nome = JOptionPane.showInputDialog("Digite o Nome:");
						telefone = JOptionPane.showInputDialog("Digite o telefone");
						dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento");
						email = JOptionPane.showInputDialog("Digite o email");
						cpf = JOptionPane.showInputDialog("Digite o CPF");
						RG = JOptionPane.showInputDialog("Digite o RG");
						numero_habilitacao = JOptionPane.showInputDialog("Digite o número da habilitação:");
						categoria_habilitacao = JOptionPane.showInputDialog("Digite a categoria da habilitação:");
						data_expedicao = JOptionPane.showInputDialog("Digite a data de expedição da habilitação:");
						
						JOptionPane.showMessageDialog(null, motorista.insereMotorista(categoria_habilitacao, numero_habilitacao, data_expedicao, nome, email, dataNascimento, telefone, RG, cpf));
						break;
					}
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida!");
					}
					break;
				} 
				case 2: {
					aux = JOptionPane.showInputDialog("O que deseja alterar?\n(1) Usuario\n(2) Empresa\n(3) Carro\n(4) Motorista");
					opcaoArea = Integer.parseInt(aux);
					switch (opcaoArea) {
					case 1:{
						cpf = JOptionPane.showInputDialog("Digite o CPF do usuário que deseja alterar:");
						email = JOptionPane.showInputDialog("Digite o novo email:");
						telefone = JOptionPane.showInputDialog("Digite o novo telefone:");
						setor = JOptionPane.showInputDialog("Digite o novo setor:");
						senha = JOptionPane.showInputDialog("Digite a nova senha:");
						
						JOptionPane.showMessageDialog(null, usuario.alteraUsuario(email, telefone, setor, senha, cpf));
						break;
					}
					case 2: {
						cnpj = JOptionPane.showInputDialog("Digite o CNPJ da empresa que você deseja alterar:");
						endereco = JOptionPane.showInputDialog("Digite o novo Endereço:");
						telefone = JOptionPane.showInputDialog("Digite o novo telefone:");
						aux = JOptionPane.showInputDialog("Digite a nova quantidade de funcionários:");
						qtd_funcionarios = Integer.parseInt(aux);
						
						JOptionPane.showMessageDialog(null, empresa.alteraEmpresa(endereco, cnpj, qtd_funcionarios, telefone));
						break;
					}
					case 3: {
						placa = JOptionPane.showInputDialog("Digite a placa do carro que deseja alterar:");
						aux = JOptionPane.showInputDialog("Digite a kilometragem por litro:");
						km_por_litro = Integer.parseInt(aux);
						
						JOptionPane.showMessageDialog(null, carro.alteraCarro(km_por_litro, placa));
						break;
					}
					case 4: {
						cpf = JOptionPane.showInputDialog("Digite o CPF que deseja alterar:");
						telefone = JOptionPane.showInputDialog("Digite o telefone");
						email = JOptionPane.showInputDialog("Digite o email");
						
						JOptionPane.showMessageDialog(null, motorista.alteraMotorista(email, telefone, cpf));
						break;
					}
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida!");
					}
					break;
				}
				case 3: {
					aux = JOptionPane.showInputDialog("O que deseja excluir?\n(1) Usuario\n(2) Empresa\n(3) Carro\n(4) Motorista");
					opcaoArea = Integer.parseInt(aux);
					switch (opcaoArea) {
					case 1:{
						cpf = JOptionPane.showInputDialog("Digite o CPF do usuário que deseja excluir:");
						
						JOptionPane.showMessageDialog(null, usuario.excluiUsuario(cpf));
						break;
					}
					case 2: {
						cnpj = JOptionPane.showInputDialog("Digite o CNPJ da empresa que você deseja excluir:");
						
						JOptionPane.showMessageDialog(null, empresa.excluiEmpresa(cnpj));
						break;
					}
					case 3: {
						placa = JOptionPane.showInputDialog("Digite a placa do carro que deseja excluir:");
						
						JOptionPane.showMessageDialog(null, carro.excluiCarro(placa));
						break;
					}
					case 4: {
						cpf = JOptionPane.showInputDialog("Digite o CPF do motorista que deseja excluir:");
						
						JOptionPane.showMessageDialog(null, motorista.excluiMotorista(cpf));
						break;
					}
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida!");
					}
					break;
				}
				case 4: {
					aux = JOptionPane.showInputDialog("O que deseja listar?\n(1) Usuario\n(2) Empresa\n(3) Carro\n(4) Motorista");
					opcaoArea = Integer.parseInt(aux);
					switch (opcaoArea) {
					case 1:{
						JOptionPane.showMessageDialog(null, usuario.listaUsuario());
						break;
					}
					case 2: {
						JOptionPane.showMessageDialog(null, empresa.listaEmpresa());
						
						break;
					}
					case 3: {
						JOptionPane.showMessageDialog(null, carro.listaCarro());
						
						break;
					}
					case 4: {
						JOptionPane.showMessageDialog(null, motorista.listaMotorista());
						
						break;
					}
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida!");
					}
					break;
				}
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar?");
		}
		
	}

}