import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
      

        // fazer uma conexao http e buscar os filmes
        String url="https://api.mocki.io/v2/549a5d8b";
        URI endereco=URI.create(url);//transformo a url em uri

        HttpClient client = HttpClient.newHttpClient(); // crio um clinte
        HttpRequest request=HttpRequest.newBuilder(endereco).GET().build(); //faço um resquest

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); // pego minha resposta
         String body= response.body(); // guardo a minha resposta 
      

        //pegar so os dados que interresam(titulo, poster, classificaçao) (parsear os dados)
       
       JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes=parser.parse(body);

        //exibir e manipular os dados

        
        for (Map<String,String> filme : listaDeFilmes) {
            
           

            System.out.print("Rank: ");
            System.out.println(filme.get("rank"));

            System.out.print("Nome do filme: ");
            System.out.println(filme.get("title"));

            System.out.print("Ano de lançamento: ");
            System.out.println(filme.get("year"));

            System.out.print("Imagem: ");
            System.out.println(filme.get("image"));

            System.out.print("Classificação: ");
            System.out.println(filme.get("imDbRating"));
            
            System.out.println();

           
            
        }
    }
}
