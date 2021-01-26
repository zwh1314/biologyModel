package com.example.volunteer.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    @ApiModelProperty(value = "视频id")
    private long videoId;

    @Column(name = "video_url")
    @ApiModelProperty(value = "视频URL")
    private String videoUrl;

    @Column(name = "video_text")
    @ApiModelProperty(value = "视频文本")
    private String videoText;

    @Column(name = "video_like")
    @ApiModelProperty(value = "视频赞数")
    private long videoLike;

    @Column(name = "video_publisher")
    @ApiModelProperty(value = "视频发布者")
    private long videoPublisher;

    @Column(name = "video_date")
    @ApiModelProperty(value = "视频发布时间")
    private Date videoDate;
}