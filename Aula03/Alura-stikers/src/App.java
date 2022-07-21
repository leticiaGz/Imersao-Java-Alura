import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
      

        // fazer uma conexao http e buscar 
        String url="https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        
        var http= new ClienteHttp();
        String json=http.buscaDados(url);


        //exibir e manipular os dados

        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos =extrator.extraiConteudos(json);

        

        for (Conteudo conteudo : conteudos) {
            

            InputStream inputStream= new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo= "saida/" + conteudo.getTitulo() + ". png";

            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

           
            System.out.println(conteudo.getTitulo());
 
        }
    }
}