import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    
    public String buscaDados(String url){
        
        try {

        URI endereco=URI.create(url);//transformo a url em uri
        HttpClient client = HttpClient.newHttpClient(); // crio um clinte
        HttpRequest request=HttpRequest.newBuilder(endereco).GET().build(); //faço um resquest

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); // pego minha resposta
        String body= response.body(); // guardo a minha resposta 

        return body;
            
        } catch (IOException | InterruptedException ex)  {
            throw new RuntimeException(ex);
        }
        
      
    }
}
