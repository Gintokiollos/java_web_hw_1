package cn.edu.hqu.cst.lecture02_02.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class Comment {
	@NotNull
	private Long id;
	@Valid
	private Movie movie;
	@NotBlank(message="评论内容不能为空")
	@Size(max=500,message="评论长度不能超过500个字符")
	private String content;
	@NotNull(message="评分不能为空")
	@Min(value=1,message="评分至少为1")
	@Max(value=5,message="评分不能超过5")
	private Integer rating;
	private static List<Comment> comments=new ArrayList<>();
	public static List<Comment> getCommentsByMovieId(Long movieId){
		return comments.stream().filter(comment->comment.getMovie().getId().equals(movieId))
				.collect(Collectors.toList());
	}
    public static void addComment(Comment comment) {
        comment.setId((long) (comments.size() + 1)); // 简单的 ID 赋值逻辑
        comments.add(comment);
    }
}
