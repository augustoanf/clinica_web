package br.edu.ifsul.util.relatorios;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Receituario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FabricaObjetos {

    public static List<Consulta> listaConsulta() {
        List<Consulta> lista = new ArrayList<>();

        Consulta consulta = new Consulta();
        consulta.setId(1);
        consulta.setPreconsulta("antes de começar a consulta");
        consulta.setPosconsulta("acabou a consulta");
        consulta.setDiaDate(new Date());
        consulta.setHoraDate(new Date());

        Medico medico = new Medico();
        medico.setNome("Carlos");
        consulta.setPaciente(medico);
        consulta.setMedico(medico);

        List<Exame> exames = new ArrayList<>();
        Exame exame1 = new Exame();
        exame1.setId(1);
        exame1.setNome("nome exame 1");
        exame1.setDescricao("descricao exame 1");
        exame1.setConsulta(consulta);
        Exame exame2 = new Exame();
        exame2.setId(2);
        exame2.setNome("nome exame 2");
        exame2.setDescricao("descricao exame 2");
        exame2.setConsulta(consulta);
        exames.add(exame1);
        exames.add(exame2);
        consulta.setExames(exames);

        List<Receituario> receituarios = new ArrayList<>();
        List<Medicamento> medicamentos = new ArrayList<>();
        Medicamento medicamento1 = new Medicamento();
        medicamento1.setId(1);
        medicamento1.setNome("medicamento 1");
        Medicamento medicamento2 = new Medicamento();
        medicamento2.setId(2);
        medicamento2.setNome("medicamento 2");
        medicamentos.add(medicamento1);
        medicamentos.add(medicamento2);
        Receituario receituario1 = new Receituario();
        receituario1.setId(1);
        receituario1.setMedicamentos(medicamentos);
        receituario1.setPosologia("posologia teste");
        receituario1.setValidadeDate(new Date());
        receituario1.setConsulta(consulta);

        lista.add(consulta);

        return lista;
    }
}