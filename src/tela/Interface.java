package tela;

import bd.*;
import modelos.*;
import bd.ServicosContratadosDAO;


public class Interface {

	public static void main(String[] args) {
		
		Cliente cl = ClienteDAO.find_one(111);
		Servicos sc = ServicosDAO.find_one_by_id(1);
		Prestador pt = PrestadorDAO.find_one_by_id(1);
		
		pt.imprimi();
		ServicosContratados ss = new ServicosContratados("28-28",cl,sc,pt,100.00);
		
		ServicosContratadosDAO.saveServiçosContratados(ss);

 }
}
