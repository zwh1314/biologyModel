package com.example.volunteer.Controller;


import com.example.volunteer.Entity.Comment;
import com.example.volunteer.Exception.VolunteerRuntimeException;

import com.example.volunteer.Request.CommentRequest;
import com.example.volunteer.Response.Response;

import com.example.volunteer.Service.CommentService;
import com.example.volunteer.enums.ResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "普通评论Controller")
@RestController
@RequestMapping("comment")
public class CommentController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;



        @PostMapping("/getCommentByPublisherId")
        @ApiOperation("获得评论by发布者Id")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "publisherId", value = "评论发布者", paramType = "query", dataType = "long"),
        })
        public Response<List<Comment>> getCommentByPublisher(@RequestParam("publisherId") long publisherId) {
            Response<List<Comment>> response = new Response<>();
            try {
                response.setSuc(commentService.getCommentByPublisher(publisherId));
            } catch (IllegalArgumentException e) {
                logger.warn("[getCommentByPublisherId Illegal Argument], publisherId: {}", publisherId, e);
                response.setFail(ResponseEnum.ILLEGAL_PARAM);
                return response;
            } catch (VolunteerRuntimeException e) {
                logger.error("[getCommentByPublisherId Runtime Exception], publisherId: {}", publisherId, e);
                response.setFail(e.getExceptionCode(), e.getMessage());
                return response;
            }  catch (Exception e) {
                logger.error("[getCommentByPublisherId Exception], publisherId: {}", publisherId, e);
                response.setFail(ResponseEnum.SERVER_ERROR);
                return response;
            }

            return response;
        }

    @PostMapping("/getCommentByRelativeText")
    @ApiOperation("获得相似文本by commentId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "relativeText", value = "相似文本", paramType = "query", dataType = "string"),
    })
    public Response<List<Comment>> getCommentByRelativeText(@RequestParam("relativeText") String relativeText) {
        Response<List<Comment>> response = new Response<>();
        try {
            response.setSuc(commentService.getCommentByRelativeText(relativeText));
        } catch (IllegalArgumentException e) {
            logger.warn("[getCommentByRelativeText Illegal Argument], relativeText: {}", relativeText, e);
            response.setFail(ResponseEnum.ILLEGAL_PARAM);
            return response;
        } catch (VolunteerRuntimeException e) {
            logger.error("[getCommentByRelativeText Runtime Exception], relativeText: {}", relativeText, e);
            response.setFail(e.getExceptionCode(), e.getMessage());
            return response;
        }  catch (Exception e) {
            logger.error("[getCommentByRelativeText Exception], relativeText: {}", relativeText, e);
            response.setFail(ResponseEnum.SERVER_ERROR);
            return response;
        }

        return response;
    }


    @PostMapping("/getCommentInOneWeek")
    @ApiOperation("获得一周评论")
    public Response<List<Comment>> getCommentInOneWeek() {
        Response<List<Comment>> response = new Response<>();
        try {
            response.setSuc(commentService.getCommentInOneWeek());
        } catch (VolunteerRuntimeException e) {
            logger.error("[getCommentInOneWeek Runtime Exception]",  e);
            response.setFail(e.getExceptionCode(), e.getMessage());
            return response;
        }  catch (Exception e) {
            logger.error("[getCommentInOneWeek Exception]", e);
            response.setFail(ResponseEnum.SERVER_ERROR);
            return response;
        }

        return response;
    }


    @PostMapping("/addComment")
        @ApiOperation("添加评论")
        public Response<Boolean> addComment(@RequestBody CommentRequest commentRequest) {
            Response<Boolean> response = new Response<>();
            try {
                response.setSuc(commentService.addComment(commentRequest));
            } catch (IllegalArgumentException e) {
                logger.warn("[addComment Illegal Argument], commentRequest: {}", commentRequest, e);
                response.setFail(ResponseEnum.ILLEGAL_PARAM);
                return response;
            } catch (VolunteerRuntimeException e) {
                logger.error("[addComment Runtime Exception], commentRequest: {}", commentRequest, e);
                response.setFail(e.getExceptionCode(), e.getMessage());
                return response;
            }  catch (Exception e) {
                logger.error("[addComment Exception], commentRequest: {}", commentRequest, e);
                response.setFail(ResponseEnum.SERVER_ERROR);
                return response;
            }

            return response;
        }

        @PostMapping("/updateCommentLikeNumber")
        @ApiOperation("更新评论赞数")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "commentId", value = "评论id", paramType = "query", dataType = "long"),
        })
        public Response<Boolean> updateCommentLikeNumber(@RequestParam("commentLikeNumber")long commentLikeNumber,@RequestParam("commentId") long commentId) {
            Response<Boolean> response = new Response<>();
            try {
                response.setSuc(commentService.updateCommentLikeNumber(commentLikeNumber,commentId));
            } catch (IllegalArgumentException e) {
                logger.warn("[updateCommentLikeNumber Illegal Argument], : commentId {}", commentId, e);
                response.setFail(ResponseEnum.ILLEGAL_PARAM);
                return response;
            } catch (VolunteerRuntimeException e) {
                logger.error("[updateCommentLikeNumber Runtime Exception], : commentId {}", commentId, e);
                response.setFail(e.getExceptionCode(), e.getMessage());
                return response;
            }  catch (Exception e) {
                logger.error("[updateCommentLikeNumber Exception], :commentId {}", commentId, e);
                response.setFail(ResponseEnum.SERVER_ERROR);
                return response;
            }

            return response;
        }

    @PostMapping("/updateCommentText")
    @ApiOperation("更新评论文本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentId", value = "评论id", paramType = "query", dataType = "long"),
    })
    public Response<Boolean> updateCommentText(@RequestParam("commentText")String commentText,@RequestParam("commentId") long commentId) {
        Response<Boolean> response = new Response<>();
        try {
            response.setSuc(commentService.updateCommentText(commentText, commentId));
        } catch (IllegalArgumentException e) {
            logger.warn("[updateCommentText Illegal Argument], : commentId {}", commentId, e);
            response.setFail(ResponseEnum.ILLEGAL_PARAM);
            return response;
        } catch (VolunteerRuntimeException e) {
            logger.error("[updateCommentText Runtime Exception], : commentId {}", commentId, e);
            response.setFail(e.getExceptionCode(), e.getMessage());
            return response;
        } catch (Exception e) {
            logger.error("[updateCommentText Exception], :commentId {}", commentId, e);
            response.setFail(ResponseEnum.SERVER_ERROR);
            return response;
        }

        return response;
    }



        @PostMapping("/deleteCommentById")
        @ApiOperation("删除评论By commentId")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "commentId", value = "评论id", paramType = "query", dataType = "long"),
        })
        public Response<Boolean> deleteActivityNewsByNewsId(@RequestParam("commentId") long commentId) {
            Response<Boolean> response = new Response<>();
            try {
                response.setSuc(commentService.deleteCommentById(commentId));
            } catch (IllegalArgumentException e) {
                logger.warn("[deleteCommentById Illegal Argument], commentId: {}", commentId, e);
                response.setFail(ResponseEnum.ILLEGAL_PARAM);
                return response;
            } catch (VolunteerRuntimeException e) {
                logger.error("[deleteCommentById Runtime Exception], commentId: {}", commentId, e);
                response.setFail(e.getExceptionCode(), e.getMessage());
                return response;
            }  catch (Exception e) {
                logger.error("[deleteCommentById Exception], commentId: {}", commentId, e);
                response.setFail(ResponseEnum.SERVER_ERROR);
                return response;
            }

            return response;
        }

    }