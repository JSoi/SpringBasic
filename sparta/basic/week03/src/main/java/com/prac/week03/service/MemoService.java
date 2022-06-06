package com.prac.week03.service;

import com.prac.week03.domain.Memo;
import com.prac.week03.domain.MemoRepository;
import com.prac.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto memoRequestDto) {
        Memo modifyingMemo = memoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾고자 하는 메모가 없습니다"));
        modifyingMemo.update(memoRequestDto);
        return modifyingMemo.getId();
    }
}
