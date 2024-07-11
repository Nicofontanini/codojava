import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PeliculaDAO {
    public void mostrarPeliculas() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Peliculas";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.printf("%-5s %-30s %-30s %-5s %-20s%n", "ID", "Titulo", "Director", "Año", "Género");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String director = resultSet.getString("director");
                int anio = resultSet.getInt("anio");
                String genero = resultSet.getString("genero");

                System.out.printf("%-5d %-30s %-30s %-5d %-20s%n", id, titulo, director, anio, genero);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
