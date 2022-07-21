import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.*;


public class GeradoraDeFigurinhas {
    
   public void cria( InputStream inputStream, String nomeArquivo) throws Exception{
    //Leitura da imagem

   /* InputStream inputStream= 
                    new URL("https://imersao-java-apis.s3.amazonaws.com/TopTVs_2.jpg").openStream(); */
    BufferedImage imagemOriginal= ImageIO.read(inputStream);


    //cria nova imagem em memoria com transparencia e com tamanho novo
    int largura= imagemOriginal.getWidth();
    int altura=imagemOriginal.getHeight();
    int novaAltura = altura+200;

    BufferedImage novaImagem= new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);

  //copiar a imagem original pra novo imagem
   Graphics2D graphics=(Graphics2D) novaImagem.getGraphics();
   graphics.drawImage(imagemOriginal, 0, 0, null);

   //configurar a fonte
   var fonte= new Font(Font.SANS_SERIF,Font.BOLD,100);
   graphics.setColor(Color.cyan);
   graphics.setFont(fonte);

    // escrever uma frase na nossa imagem
    graphics.drawString("Legal", 100, novaAltura-100);

    //escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));

   }

   
}
