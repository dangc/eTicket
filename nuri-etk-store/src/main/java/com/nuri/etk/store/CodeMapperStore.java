package com.nuri.etk.store;

import com.nuri.etk.entity.aimir.Code;
import com.nuri.etk.store.mapper.CodeMapper;
import org.springframework.stereotype.Component;

@Component
public class CodeMapperStore implements CodeStore {

    private final CodeMapper codeMapper;


    public CodeMapperStore(CodeMapper codeMapper) {
        this.codeMapper = codeMapper;
    }

    @Override
    public Code getkeyType(String payTypeId) {
        return null;
    }
}
