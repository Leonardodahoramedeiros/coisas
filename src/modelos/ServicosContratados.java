package modelos;

import modelos.Cliente;
import modelos.Prestador;
import modelos.Servicos;



	public class ServicosContratados {
		
		private int id;
		private String data;
		private Cliente cliente;
		private Servicos servicos;
		private Prestador prestador;
		private double valor;
		
		
		
		
		public ServicosContratados(String data, Cliente cliente, Servicos servicos, Prestador prestador, double valor){
			
			this.data=data;
			this.cliente=cliente;
			this.servicos=servicos;
			this.prestador=prestador;
			this.valor=valor;
			
		}
		public ServicosContratados(int id, String data, Cliente cliente, Servicos servicos, Prestador prestador, double valor){
			this.id=id;
			this.data=data;
			this.cliente=cliente;
			this.servicos=servicos;
			this.prestador=prestador;
			this.valor=valor;
			
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getData() {
			return data;
		}


		public void setData(String data) {
			this.data = data;
		}


		public Cliente getCliente() {
			return cliente;
		}


		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}


		public Servicos getServicos() {
			return servicos;
		}


		public void setServicos(Servicos servicos) {
			this.servicos = servicos;
		}


		public Prestador getPrestador() {
			return prestador;
		}


		public void setPrestador(Prestador prestador) {
			this.prestador = prestador;
		}


		public double getValor() {
			return valor;
		}


		public void setValor(double valor) {
			this.valor = valor;
		}
		
		//public void imprimi() {
			//System.out.println(id + " " + );
		//}
		

		

	}



