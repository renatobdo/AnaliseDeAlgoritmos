package exemplos;

import java.util.ArrayList;
import java.util.List;

public class MochilaFracionaria {
	private static MochilaFracionaria mf = new MochilaFracionaria();
	private static List<Objeto> objetos = new ArrayList<Objeto>();
	
	public static void main(String[] args) {
		Objeto o;
		
		o = mf.new Objeto(1,60L, 10L);
		objetos.add(o);
		o = mf.new Objeto(2,100L, 20L);
		objetos.add(o);
		o = mf.new Objeto(3,120L, 30L);
		objetos.add(o);
		
		for(Objeto objeto: objetos) {
			System.out.println("código: "+objeto.codigo);
			System.out.println("peso: "+objeto.peso);
			System.out.println("valor: "+objeto.valor);
		}
		long capacidade = 50L;
		System.out.println("Valor da mochila = "+ valorDaMochila(objetos,capacidade));
	}
	public MochilaFracionaria() {
		// TODO Auto-generated constructor stub
	}
	private static long valorDaMochila(List<Objeto>objetos, Long c) {
		long pesoAtual = 0L;
		long valorMochila = 0L;
		System.out.println("tamanho dos objetos: "+objetos.size());
		for(int i = 0;i<objetos.size(); i++) {
			Objeto objeto = objetos.get(i);
			if(pesoAtual + objeto.peso <= c) {
				pesoAtual += objeto.peso;
				i++;
			}
			if(i<objetos.size()) {
				Long valorFracionado = Math.floorDiv(c - pesoAtual, objeto.peso);
				valorFracionado = Math.multiplyExact(valorFracionado, objeto.valor);
				valorMochila += valorFracionado;
			}
		}
		return valorMochila;
	}
	class Objeto implements Comparable<Objeto>{
		
		public int codigo;
		public long valor;
		public long peso;

		public Objeto(int i, long l, long m) {
			// TODO Auto-generated constructor stub
			this.codigo = i;
			this.valor = l;
			this.peso = m;
		}

		@Override
		public int compareTo(Objeto o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

}
