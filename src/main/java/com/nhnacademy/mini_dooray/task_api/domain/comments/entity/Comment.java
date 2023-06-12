package com.nhnacademy.mini_dooray.account_api.domain.comments.entity;

import com.nhnacademy.mini_dooray.account_api.domain.tasks.entity.Task;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Setter
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "task_id")
    private Task task;

    @Setter
    @NotNull
    @Column(name = "account_id")
    private Long accountId;

    @Setter
    @Length(max = 45)
    @Column(name = "comment_content")
    private String commentContent;

    public Comment(Task task, Long accountId, String commentContent) {
        this.commentId = null;
        this.task = task;
        this.accountId = accountId;
        this.commentContent = commentContent;
    }
}