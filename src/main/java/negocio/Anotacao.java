package negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Anotacao {
    private int id;
    private String titulo;
    private String texto;
    private String cor;
    private LocalDateTime datahora;
    private byte[] foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void setFoto(String diretorio) throws FileNotFoundException, IOException {
        File f = new File(diretorio);
        FileInputStream fileInputStream = new FileInputStream(f);
        this.foto = fileInputStream.readAllBytes();
        fileInputStream.close();
    }

    @Override
    public String toString() {
        return "Anotacao [id=" + id + ", titulo=" + titulo + ", cor=" + cor + ", datahora=" + datahora + ", foto="
                + Arrays.toString(foto) + "]";
    }

}
