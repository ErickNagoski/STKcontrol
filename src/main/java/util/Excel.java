package util;

import Controllers.ProductTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class Excel {
    public static void GeraExcel(ArrayList<ProductTable> produtos) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Estoque de Produtos");
        Map<String, Object[]> data = CreateObjects(produtos);
        Set<String> keyset = data.keySet();
        int rownum = 0;
        Iterator var6 = keyset.iterator();

        while(var6.hasNext()) {
            String key = (String)var6.next();
            Row row = sheet.createRow(rownum++);
            Object[] objArr = (Object[])data.get(key);
            int cellnum = 0;
            Object[] var11 = objArr;
            int var12 = objArr.length;

            for(int var13 = 0; var13 < var12; ++var13) {
                Object obj = var11[var13];
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String)obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((double)(Integer)obj);
                }
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File("Estoque.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception var16) {
            var16.printStackTrace();
        }

   }

    private static Map<String, Object[]> CreateObjects(ArrayList<ProductTable> produtos) {
        Map<String, Object[]> data = new TreeMap();
        data.put("1", new Object[]{"Código", "Descrição", "Preço Unitário","%IPI", "Unidade de Medida", "Qtd. Estoque","Endereço", "Código Fornecedor", "Fornecedor", "Preço de Custo"});

        for (int i = 0; i < produtos.size(); i++) {
            data.put(""+(i+2), new Object[]{
                    produtos.get(i).getCodigo(),
                    produtos.get(i).getDescricao(),
                    String.valueOf(produtos.get(i).getPreco_venda()),
                    String.valueOf(produtos.get(i).getIpi()),
                    produtos.get(i).getUnidadeMedida(),
                    String.valueOf(produtos.get(i).getQuantidade()),
                    produtos.get(i).getEndereco(),
                    produtos.get(i).getCodigoFornecedor(),
                    produtos.get(i).getFornecedor(),
                    String.valueOf(produtos.get(i).getPre_custo())
            });
        }
        return data;
    }
}
