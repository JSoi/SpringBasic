package com.prac.week03.controller;

import com.prac.week03.domain.Memo;
import com.prac.week03.domain.MemoRepository;
import com.prac.week03.domain.MemoRequestDto;
import com.prac.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/api/memos")
    public List<Memo> showMemos() {
        //return memoRepository.findAllByOrderByModifiedAtDesc();
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime.now().minusDays(1), LocalDateTime.now());
    }

    @PostMapping("/api/memos")
    public Memo addMemo(@RequestBody MemoRequestDto memoRequestDto) {
        return memoRepository.save(new Memo(memoRequestDto));
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto) {
        return memoService.update(id, memoRequestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
