package com.nuri.etk.store;

import com.nuri.etk.entity.aimir.*;
import com.nuri.etk.entity.pojo.ChargeInfo;
import com.nuri.etk.store.jpo.aimir.ContractJpo;
import com.nuri.etk.store.jpo.aimir.DeviceModelJpo;
import com.nuri.etk.store.jpo.aimir.DeviceVendorJpo;
import com.nuri.etk.store.jpo.aimir.MeterJpo;
import com.nuri.etk.store.mapper.ChargeMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChargeMapperStore implements ChargeStore {

    private final ChargeMapper chargeMapper;

    public ChargeMapperStore(ChargeMapper chargeMapper) {
        this.chargeMapper = chargeMapper;
    }

    @Override
    public ChargeInfo meterCharge(String meterId, HttpHeaders headers, ChargeInfo chargeInfo) {
        return null;
    }

    @Override
    public Meter getMeter(String meterId) {
        Meter meter = new Meter();
        DeviceVendorJpo deviceVendorJpo = null;
        DeviceModelJpo deviceModelJpo = null;
        MeterJpo meterJpo = null;

        try {
            deviceVendorJpo = chargeMapper.getMeterDeviceVendor(meterId);
            deviceModelJpo = chargeMapper.getMeterDeviceModel(meterId);
            meterJpo = chargeMapper.getMeterById(meterId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        meter = meterJpo.toDomain();
        deviceModelJpo.setDeviceVendor(deviceVendorJpo.toDomain());
        meter.setModel(deviceModelJpo.toDomain());

        return meter;
    }

    @Override
    public Contract getContract(String meterId) {
        ContractJpo contractJpo = null;
        try {
            contractJpo = chargeMapper.getContract(meterId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contractJpo.toDomain();
    }

    @Override
    public List<DebtEnt> getDebt(String customerNo, String debtType, String debtRef) {
        return null;
    }

    @Override
    public Operator getOperator(String operatorId) {
        return null;
    }

    @Override
    public Code getMeterStatusCode(Integer meterStatusCodeId) {
        return null;
    }

    @Override
    public void addPrepaymentLog(PrepaymentLog prepaymentLog) {

    }

    @Override
    public void addDepositHistory(DepositHistory dh) {

    }

    @Override
    public void addDebtLog(DebtLog debtLog) {

    }

    @Override
    public void updateOperator(Operator updateOperator) {

    }

    @Override
    public void updateDebtEnt(DebtEnt debtEnt) {

    }

    @Override
    public void updateContract(Contract contract) {

    }

    @Override
    public void addAsyncCommandLog(AsyncCommandLog asyncCommandLog) {

    }

    @Override
    public Integer getMaxNum(String deviceSerial, long trId) {
        return null;
    }

    @Override
    public void addAsyncCommandParam(AsyncCommandParam asyncCommandParam) {

    }

    @Override
    public void addContractChangeLog(ContractChangeLog contractChangeLog) {

    }

    @Override
    public void addSTSlog(EcgSTSLog stslog) {

    }
}
