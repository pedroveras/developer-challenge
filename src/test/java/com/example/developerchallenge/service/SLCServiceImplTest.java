package com.example.developerchallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.developerchallenge.model.BCMSG;
import com.example.developerchallenge.model.Doc;
import com.example.developerchallenge.model.GrupoSLC0001Liquid;
import com.example.developerchallenge.model.GrupoSLC0001LiquidProdt;
import com.example.developerchallenge.model.GrupoSLC0001Prodt;
import com.example.developerchallenge.model.GrupoSeq;
import com.example.developerchallenge.model.SISMSG;
import com.example.developerchallenge.model.SLC0001;
import com.example.developerchallenge.repository.SLCRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import org.hibernate.internal.util.xml.BufferedXMLEventReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ErrorCollector;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sun.misc.IOUtils;

@ExtendWith(MockitoExtension.class)
class SLCServiceImplTest {

    private static final String IDENTD_DEST = "12345678";
    private static final String IDENTD_EMISSOR = "99999999";
    private static final String NU_OP = "12345678912345678912345";
    private static final String DOM_SIST = "SPB01";
    private static final String NUM_SEQ = "1";
    private static final String INDR_CONT = "N";
    private static final String COD_MSG = "SLC0001";
    private static final String NUM_CTRL_SLC = "12345678912345678912";
    private static final String ISPBIF = "12345678";
    private static final String DT_MOV_TO = "2019-01-01";
    private static final String DT_HR_SLC = "2019-01-01T08:40:21";
    private static final String DT_LIQUID = "2019-01-01";
    private static final String NUM_SEQ_CICLO_LIQUID = "1";
    private static final String TP_TRANSAC_SLC_1 = "02";
    private static final String CNPJN_LIQUIDANT_CREDITD_1 = "02181332000145";
    private static final String CNPJN_LIQUIDANT_DEBTD_1 = "47515515000198";
    private static final String IDENTID_LINHA_BILAT_1 = "12345678VCC3456789";
    private static final String ISPBIF_CRED_1 = "99999999";
    private static final String ISPBIF_DEBD_1 = "99999999";
    private static final String NOM_CLI_DEBTD_1 = "BANCOBOB";
    private static final String NOM_CLI_CREDTD_1 = "BANCO";
    private static final String TP_DEB_CRED_1 = "C";
    private static final String VLR_LANC_1 = "16990.85";
    private static final String TP_TRANSAC_SLC_2 = "02";
    private static final String CNPJN_LIQUIDANT_CREDITD_2 = "23333472000161";
    private static final String CNPJN_LIQUIDANT_DEBTD_2 = "50276286000100";
    private static final String IDENTID_LINHA_BILAT_2 = "10045678VCC3456789";
    private static final String ISPBIF_CRED_2 = "99999999";
    private static final String ISPBIF_DEBD_2 = "99999999";
    private static final String NOM_CLI_DEBTD_2 = "TRIANGULO";
    private static final String NOM_CLI_CREDTD_2 = "BANCO";
    private static final String TP_DEB_CRED_2 = "C";
    private static final String VLR_LANC_2 = "3171.76";
    private static final String COD_PRODT = "VCC";
    private static final String TP_INF = "P";
    private static final String FILENAME = "SLC0001.xml";
    private static String dadosArquivo;

    @InjectMocks
    private SLCService service = new SLCServiceImpl();

    @Mock
    private SLCRepository repository;

    @Captor
    public ArgumentCaptor<Doc> docArgumentCaptor;

    public final ErrorCollector collector = new ErrorCollector();

    private Doc doc;
    private BCMSG bcmsg;
    private SISMSG sismsg;
    private SLC0001 slc0001;
    private GrupoSeq grupoSeq;
    private GrupoSLC0001Liquid grupoSLC0001Liquid;
    private GrupoSLC0001LiquidProdt grupoSLC0001LiquidProdt;
    private GrupoSLC0001Prodt grupoSLC0001Prodt;

    static {
        ClassLoader classLoader = SLCServiceImplTest.class.getClassLoader();
        URL resource = classLoader.getResource(FILENAME);
        File arquivo = new File(resource.getFile());

        try (FileReader reader = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(reader)) {

            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append(System.lineSeparator());
            }

            int last = stringBuffer.lastIndexOf(System.lineSeparator());
            stringBuffer.delete(last, stringBuffer.length());
            dadosArquivo = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void setUp() {
        grupoSeq = new GrupoSeq();
        grupoSeq.setNumSeq(NUM_SEQ);
        grupoSeq.setIndrCont(INDR_CONT);

        bcmsg = BCMSG.builder()
                .domSist(DOM_SIST)
                .grupoSeq(grupoSeq)
                .identdDestinatario(IDENTD_DEST)
                .identdEmissor(IDENTD_EMISSOR)
                .nuOp(NU_OP).build();

        grupoSLC0001LiquidProdt = GrupoSLC0001LiquidProdt.builder()
                .tpTranscSLC(TP_TRANSAC_SLC_1)
                .cnpjnLiqdantCredtd(CNPJN_LIQUIDANT_CREDITD_1)
                .cnpjnLiqdantDebtd(CNPJN_LIQUIDANT_DEBTD_1)
                .identdLinhaBilat(IDENTID_LINHA_BILAT_1)
                .ispbifCredtd(ISPBIF_CRED_1)
                .ispbifDebtd(ISPBIF_DEBD_1)
                .nomCliCredtd(NOM_CLI_CREDTD_1)
                .nomCliDebtd(NOM_CLI_DEBTD_1)
                .tpDebCred(TP_DEB_CRED_1)
                .vlrLanc(VLR_LANC_1).build();

        GrupoSLC0001LiquidProdt grupoSLC0001LiquidProdt2 = GrupoSLC0001LiquidProdt.builder()
                .tpTranscSLC(TP_TRANSAC_SLC_2)
                .cnpjnLiqdantCredtd(CNPJN_LIQUIDANT_CREDITD_2)
                .cnpjnLiqdantDebtd(CNPJN_LIQUIDANT_DEBTD_2)
                .identdLinhaBilat(IDENTID_LINHA_BILAT_2)
                .ispbifCredtd(ISPBIF_CRED_2)
                .ispbifDebtd(ISPBIF_DEBD_2)
                .nomCliCredtd(NOM_CLI_CREDTD_2)
                .nomCliDebtd(NOM_CLI_DEBTD_2)
                .tpDebCred(TP_DEB_CRED_2)
                .vlrLanc(VLR_LANC_2).build();

        grupoSLC0001Prodt = new GrupoSLC0001Prodt();
        grupoSLC0001Prodt.setCodProdt(COD_PRODT);
        grupoSLC0001Prodt.setGrupoSLC0001LiquidProdt(Arrays.asList(grupoSLC0001LiquidProdt, grupoSLC0001LiquidProdt2));

        grupoSLC0001Liquid = new GrupoSLC0001Liquid();
        grupoSLC0001Liquid.setDtLiquid(DT_LIQUID);
        grupoSLC0001Liquid.setNumSeqCicloLiquid(NUM_SEQ_CICLO_LIQUID);
        grupoSLC0001Liquid.setGrupoSLC0001Prodt(Collections.singletonList(grupoSLC0001Prodt));


        slc0001 = SLC0001.builder()
                .codMsg(COD_MSG)
                .dtHrSLC(DT_HR_SLC)
                .dtMovto(DT_MOV_TO)
                .grupoSLC0001Liquid(grupoSLC0001Liquid)
                .ispbif(ISPBIF)
                .numCtrlSLC(NUM_CTRL_SLC)
                .tpInf(TP_INF).build();

        sismsg = new SISMSG();
        sismsg.setSlc0001(slc0001);

        doc = new Doc();
        doc.setBcmsg(bcmsg);
        doc.setSismsg(sismsg);
    }

    @Test
    void testSalvarArquivo() {
        // Act
        service.salvarArquivo(doc);

        // Assert
        verify(repository).save(docArgumentCaptor.capture());
        assertEquals(doc, docArgumentCaptor.getValue());
    }

    @Test
    void testcarregarArquivo() {
        // Arrange
        when(repository.getByNuOp(NU_OP)).thenReturn(Optional.of(doc));

        // Act
        String xml = service.carregarArquivo(NU_OP);

        // Assert
        xml = xml.replaceAll("    ","");
        dadosArquivo = dadosArquivo.replaceAll("\t|  |    ", "");
        verify(repository).getByNuOp(NU_OP);
        assertEquals(dadosArquivo, xml);
    }
}
