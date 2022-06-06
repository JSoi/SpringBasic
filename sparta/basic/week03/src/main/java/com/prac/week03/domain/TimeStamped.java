package com.prac.week03.domain;

import lombok.Getter;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 상속시 자동으로 컬럼화됨
@EntityListeners(AuditingEntityListener.class) //생성,변경 시간 업데이트
public class TimeStamped {
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
