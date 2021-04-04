package com.example.volunteer.Service;

import com.example.volunteer.DTO.ActivityDTO;
import com.example.volunteer.Entity.ActivitySignFile;
import com.example.volunteer.Entity.ActivityUser;
import com.example.volunteer.Request.ActivityUserRequest;
import com.example.volunteer.Response.Response;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface  ActivityUserService {
    /**增加活动
     * @param activityUserRequest
     * @return 成功返回true，失败返回false
     */
    Response<Boolean> addActivityUser(ActivityUserRequest activityUserRequest);

    /**更新报名表状态
     * @param userId，formStatus
     * @return 成功返回true，失败返回false
     */
    Response<Boolean> updateFormStatusByUserId(String formStatus,long userId);

    /**更新交表日期
     * @param userId，formDate
     * @return 成功返回true，失败返回false
     */
    Response<Boolean> updateFormDateByUserId(Date formDate, long userId);
    /**
     * 通过id查询活动
     * @param userId
     * @return 查询结果链表
     */
    Response<List<ActivityUser>> getActivityUserByUserId(long userId);

    /**
     * 通过id查询活动
     * @param activityId
     * @return 查询结果链表
     */
    Response<List<ActivityUser>> getActivityUserByActivityId(long activityId);


    /**删除活动
     * @param activityId
     * @return 成功返回true，失败返回false
     */
    Response<Boolean> deleteActivityUserByActivityId(long activityId);

    /**删除活动
     * @param userId
     * @return 成功返回true，失败返回false
     */
    Response<Boolean> deleteActivityUserByUserId(long userId);

    /**下载活动报名表
     * @param activityId
     * @return 查询结果链表
     */
    Response<List<ActivitySignFile>> getSignFile(long activityId);

    /**上传活动报名表
     * @param activityId
     * @param signFile
     * @return 成功返回true，失败返回false
     */
    Response<Boolean> uploadSignFile(long userId, long activityId, MultipartFile[] signFile);

    /**通过id查询已经参加的活动
     * @param userId
     * @return 查询结果链表
     */
    Response<List<ActivityDTO>>getParticipatedActivityByUserId(long userId);

    /**
     * 获得用户已关注的活动
     * @param userId
     * @return
     */
    Response<List<ActivityDTO>> getFocusedByUserId(long userId);
    /**
     * 获得用户已报名的活动
     * @param userId
     * @return
     */
    public Response<List<ActivityDTO>> getSignedUpActivityByUserId(long userId);
}
