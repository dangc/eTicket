package com.nuri.etk.logic;

import com.nuri.etk.spec.UsageService;
import com.nuri.etk.store.UsageStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsageLogic implements UsageService {

    private final UsageStore usageStore;

    public UsageLogic(UsageStore usageStore) {
        this.usageStore = usageStore;
    }

}
