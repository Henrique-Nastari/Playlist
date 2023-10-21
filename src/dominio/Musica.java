package dominio;

public class Musica {
	private String titulo;
	private String cantor;
	private int duracao; //em segundos

	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	public void setCantor(String cantor){
		this.cantor = cantor;
	}
	public void setDuracao(int duracao){
		this.duracao = duracao;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public int getDuracao() {
		return duracao;
	}
	public String getCantor() {
		return cantor;
	}
	public String estado() {
		return titulo+"-"+cantor+"-"+duracao;
	}
}
