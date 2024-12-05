package com.devpro.yuubook.services;

import com.devpro.yuubook.models.dto.CommentDTO;
import com.devpro.yuubook.models.entities.Comment;
import com.devpro.yuubook.models.entities.User;

import java.util.List;

public interface CommentService {

	void saveCommentByUserLogin(User userLogin, CommentDTO commentDTO);

	void deleteCommentByUserLogin(User userLogin, int cmtId);

	Comment likeComment(User userLogin, int cmtId);

	Comment dislikeComment(User userLogin, int cmtId);

	List<Comment> getCommentsByUserLogin(User userLogin);

	List<Comment> getAll();

	void deleteById(int id);
}
