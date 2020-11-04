package com.nuri.etk.store;

import com.nuri.etk.store.mapper.ReceiptMapper;
import com.nuri.etk.store.mapper.UsageMapper;
import org.springframework.stereotype.Component;

@Component
public class UsageMapperStore implements UsageStore {

    private final UsageMapper usageMapper;

    public UsageMapperStore(UsageMapper usageMapper) {
        this.usageMapper = usageMapper;
    }

}
