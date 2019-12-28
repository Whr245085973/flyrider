package me.hongren.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName Log
 * @Description: TODO
 * @Author Tomy
 * @Date 2019/12/27
 * @Version V1.0
 **/
@Entity
@Data
@Table(name = "log")
@NoArgsConstructor
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String description;

    private String method;

    @Column(columnDefinition = "text")
    private String params;

    @Column(name = "log_type")
    private String logType;

    @Column(name = "request_ip")
    private String requestIp;

    @Column(name = "address")
    private String address;

    private String browser;

    //请求时间
    private Long time;

    @Column(name = "exception_detail",columnDefinition = "text")
    private byte[] exceptionDetail;

    //创建时间
    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;

    }

}
