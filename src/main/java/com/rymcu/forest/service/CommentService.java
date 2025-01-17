package com.rymcu.forest.service;

import com.rymcu.forest.core.service.Service;
import com.rymcu.forest.dto.CommentDTO;
import com.rymcu.forest.entity.Comment;
import com.rymcu.forest.web.api.exception.BaseApiException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author ronger
 */
public interface CommentService extends Service<Comment> {

    /**
     * 获取文章评论数据
     * @param idArticle
     * @return
     */
    List<CommentDTO> getArticleComments(Integer idArticle);

    /**
     * 评论
     * @param comment
     * @param request
     * @return
     */
    Map postComment(Comment comment, HttpServletRequest request) throws BaseApiException;

    /**
     * 获取评论列表数据
     * @return
     */
    List<CommentDTO> findComments();
}
