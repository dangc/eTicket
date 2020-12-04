package com.nuri.etk.store;

import com.nuri.etk.entity.aimir.*;
import com.nuri.etk.entity.pojo.ChargeInfo;
import com.nuri.etk.entity.pojo.PaymentInfo;
import com.nuri.etk.store.jpo.PaymentInfoJpo;
import com.nuri.etk.store.jpo.aimir.*;
import com.nuri.etk.store.mapper.ChargeMapper;
import com.nuri.etk.store.mapper.MeterMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChargeMapperStore implements ChargeStore {

    private final ChargeMapper chargeMapper;
    private final MeterMapper meterMapper;

    public ChargeMapperStore(ChargeMapper chargeMapper, MeterMapper meterMapper) {
        this.chargeMapper = chargeMapper;
        this.meterMapper = meterMapper;
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
        ModemJpo modemJpo = null;
        ContractJpo contractJpo = null;

        try {
            deviceVendorJpo = chargeMapper.getMeterDeviceVendor(meterId);
            deviceModelJpo = chargeMapper.getMeterDeviceModel(meterId);
            meterJpo = chargeMapper.getMeterById(meterId);
            modemJpo = chargeMapper.getMeterModem(meterId);
            contractJpo = chargeMapper.getContract(meterId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        meter = meterJpo.toDomain();
        deviceModelJpo.setDeviceVendor(deviceVendorJpo.toDomain());
        meter.setModel(deviceModelJpo.toDomain());
        meter.setModem(modemJpo.toDomain());
        meter.setContract(contractJpo.toDomain());

        return meter;
    }

    @Override
    public MCU getMCU(String meterId) {
        MCUJpo mcuJpo = null;

        try {
            mcuJpo = chargeMapper.getMCU(meterId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mcuJpo.toDomain();
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

    @Override
    public APICallBackHistory getCallbackHistory(String uuid) {
        return null;
    }

    @Override
    public APICallBackHistory getAPICallBackHistory(String uuid) {
        return null;
    }

    @Override
    public PrepaymentLog getPrepayLog(String id, String meterId) {
        PrepaymentLogJpo prepaymentLog = null;
        try {
            prepaymentLog = chargeMapper.getPrepayLog(id, meterId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prepaymentLog.toDomain();
    }

    @Override
    public Contract getContractById(Integer contractId) {
        ContractJpo contractJpo = null;
        try {
            contractJpo = chargeMapper.getContractById(contractId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contractJpo.toDomain();
    }

    @Override
    public Supplier getSupplier(Integer supplierId) {
        return null;
    }
}
