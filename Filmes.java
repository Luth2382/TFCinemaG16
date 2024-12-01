public class Filmes {
    public int codigo;
    public String nome;
    public String genero;
    public String sinopse;

    public Filmes(int codigo, String nome, String genero, String sinopse){
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
    } 

    public void setCodigo(int codigo){this.codigo = codigo;}
    public int getCodigo(){return this.codigo;}


    public void setNome(String nome){this.nome = nome;}
    public String getNome(){return this.nome;}


    public void setGenero(String genero){this.genero = genero;}
    public String getGenero(){return this.genero;}


    public void setSinopse(String sinopse){this.sinopse = sinopse;}
    public String getSinopse(){return this.sinopse;}

    
    
    
    
    public String toString(){
        return "Codigo: " + getCodigo() + "\nNome: " + getNome() + "\nGenero: " + getGenero() + "\nSinopse: " + getSinopse() + "\n";
    }
    


}