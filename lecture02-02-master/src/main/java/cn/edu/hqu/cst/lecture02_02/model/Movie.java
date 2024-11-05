package cn.edu.hqu.cst.lecture02_02.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Movie {
	 private Long id;
	    @NotBlank(message = "标题不能为空")
	    @Size(max = 100, message = "标题长度不能超过 100 个字符")
	    private String title;
	    @NotBlank(message = "导演不能为空")
	    @Size(max = 100, message = "导演长度不能超过 100 个字符")
	    private String director;
	    @Size(max = 500, message = "描述长度不能超过 500 个字符")
	    private String description;
	    private String posterUrl;
	    // 静态列表模拟数据库
	    private static List<Movie> movies = new ArrayList<>();
	 // 使用静态方法来模拟数据库操作
	    public static List<Movie> getAllMovies() {
	        return new ArrayList<>(movies);
	    }
	    public static void addMovie(Movie movie) {
	        movie.setId((long) (movies.size() + 1)); // 简单的 ID 赋值逻辑
	        movies.add(movie);
	    }
	    public static Movie getMovieById(Long id) {
	        return movies.stream()
	                .filter(movie -> movie.getId().equals(id))
	                .findFirst()
	                .orElse(null);
	    }
	    public static void deleteMovie(Long id) {
	        movies.removeIf(movie -> movie.getId().equals(id));
	    }

	

}
