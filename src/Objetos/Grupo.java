package Objetos;
// Generated 03/06/2016 10:35:37 by Hibernate Tools 4.3.1


import Util.AtributoValor;
import Util.FormatoDataHora;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Grupo generated by hbm2java
 */
public class Grupo  implements java.io.Serializable {


     private GrupoId id;
     private Membro lider;
     private String tipoGrupo;
     private String endRua;
     private int endNumero;
     private String endCompl;
     private String endBairro;
     private String endCidade;
     private Set membros = new HashSet(0);

    public Grupo() {
        this.id = new GrupoId();
    }

	
    public Grupo(Date hora, String diaSemana, Membro lider, String endRua, int endNumero, String endCompl, String endBairro, String endCidade, String tipoGrupo) {
        this.id = new GrupoId();
        this.id.setHora(hora);
        this.id.setDiaSemana(diaSemana);
        setLider(lider);
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endCompl = endCompl;
        this.endBairro = endBairro;
        this.endCidade = endCidade;
        this.tipoGrupo = tipoGrupo;
    }
    public Grupo(Date hora, String diaSemana, Membro lider, String tipoGrupo, String endRua, int endNumero, String endCompl, String endBairro, String endCidade, Set membros) {
       this.id = new GrupoId();
       this.id.setHora(hora);
       this.id.setDiaSemana(diaSemana);
       setLider(lider);
       this.tipoGrupo = tipoGrupo;
       this.endRua = endRua;
       this.endNumero = endNumero;
       this.endCompl = endCompl;
       this.endBairro = endBairro;
       this.endCidade = endCidade;
       this.membros = membros;
    }
   
    public GrupoId getId() {
        return this.id;
    }
    
    public void setId(GrupoId id) {
        this.id = id;
    }
    public Membro getLider() {
        return this.lider;
    }
    
    public final void setLider(Membro lider) {
        this.lider = lider;
        this.id.setIdLider(lider.getId());
    }
    public String getTipoGrupo() {
        return this.tipoGrupo;
    }
    
    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }
    public String getEndRua() {
        return this.endRua;
    }
    
    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }
    public int getEndNumero() {
        return this.endNumero;
    }
    
    public void setEndNumero(int endNumero) {
        this.endNumero = endNumero;
    }
    public String getEndCompl() {
        return this.endCompl;
    }
    
    public void setEndCompl(String endCompl) {
        this.endCompl = endCompl;
    }
    public String getEndBairro() {
        return this.endBairro;
    }
    
    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }
    public String getEndCidade() {
        return this.endCidade;
    }
    
    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }
    public Set getMembros() {
        return this.membros;
    }
    
    public void setMembros(Set membros) {
        this.membros = membros;
    }

    ///////////////////////////////////////////////////////////
    
    public static Grupo preencherDadosGrupo(Object[] object, int index){
        Grupo grupo = new Grupo();
        grupo.setId(new GrupoId((Integer)object[index],(Date)object[index+1],(String)object[index+2]));
        if (object[index+3] != null)
            grupo.setTipoGrupo((String)object[index+3]);
        grupo.setEndRua((String)object[index+4]);
        grupo.setEndNumero((Integer)object[index+5]);
        if (object[index+6] != null)
            grupo.setEndCompl((String)object[index+6]);
        grupo.setEndBairro((String)object[index+7]);
        grupo.setEndCidade((String)object[index+8]);
        return grupo;
    }
    
    public static List<Grupo> preencherDadosGrupo(List<Object[]> objects, int index){
        List<Grupo> grupos = new ArrayList();
        for(Object[] obj: objects){
            grupos.add(preencherDadosGrupo(obj, index));
        }
        return grupos;
    }
    
    public static void cadastrarGrupo(Grupo grupo) throws Exception{
        HibernateUtil.persistirObjeto(grupo);
    }
    
    public static void atualizarGrupo(Grupo grupoOld, Grupo grupoNew) throws Exception{
        String where = "id_lider = "+grupoOld.getId().getIdLider()+ " and hora = '"+FormatoDataHora.sqlHora(grupoOld.getId().getHora())+"' and dia_semana = '"+grupoOld.getId().getDiaSemana()+"'";
        List<AtributoValor> valores = new ArrayList();
        valores.add(new AtributoValor("id_lider",""+grupoNew.getId().getIdLider()));
        valores.add(new AtributoValor("hora","'"+FormatoDataHora.sqlHora(grupoNew.getId().getHora())+"'"));
        valores.add(new AtributoValor("dia_semana","'"+grupoNew.getId().getDiaSemana()+"'"));
        valores.add(new AtributoValor("tipo_grupo","'"+grupoNew.getTipoGrupo()+"'"));
        valores.add(new AtributoValor("end_rua","'"+grupoNew.getEndRua()+"'"));
        valores.add(new AtributoValor("end_numero",""+grupoNew.getEndNumero()));
        valores.add(new AtributoValor("end_compl","'"+grupoNew.getEndCompl()+"'"));
        valores.add(new AtributoValor("end_bairro","'"+grupoNew.getEndBairro()+"'"));
        valores.add(new AtributoValor("end_cidade","'"+grupoNew.getEndCidade()+"'"));
        HibernateUtil.update("grupo", valores, where);
    }
    
    public static void deletarGrupo(Grupo grupo) throws Exception{
        HibernateUtil.deletarObjeto(grupo);
    }
    
    public static Grupo selectGrupoPk(GrupoId id){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("Grupo", "id_lider="+id.getIdLider() + " and hora='"+FormatoDataHora.sqlHora(id.getHora())+ "' and dia_semana='"+id.getDiaSemana()+"'","",0);
        return preencherDadosGrupo(objects.get(0),0);
    }
    
    public static Grupo selectGrupoPk(int id_lider, Date hora, String dia_semana){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("Grupo", "id_lider="+id_lider + " and hora='"+FormatoDataHora.sqlHora(hora)+ "' and dia_semana='"+dia_semana+"'","",0);
        return preencherDadosGrupo(objects.get(0),0);
    }
    
    public static List<Grupo> listarTodos(){
        List<Object[]> objects = HibernateUtil.rodarSQL("select p.id, p.nome, p.sobrenome, p.telefone, p.end_rua as end_rua_membro, p.end_numero as end_numero_membro, p.end_comp as end_comp_membro, p.end_bairro as end_bairro_membro, p.end_cidade as end_cidade_membro, p.end_estado as end_estado_membro, p.email, p.estado_civil, m.cpf, m.data_nasc, m.batismo_apres, m.usuario, m.senha, m.permissoes, m.id_lider as id_lider_membro, m.hora_grupo, m.dia_sem_grupo, g.id_lider, g.hora, g.dia_semana, g.tipo_grupo, g.end_rua, g.end_numero, g.end_compl, g.end_bairro, g.end_cidade\n" +
"from (pessoa p natural join membro m) join grupo g on p.id= g.id_lider");
        Membro lider;
        Grupo grupo;
        List<Grupo> grupos = new ArrayList();
        for (Object[] object: objects){
            lider = Membro.preencherDadosMembro(object, 0);
            grupo = preencherDadosGrupo(object, 21);
            grupo.setLider(lider);
            grupos.add(grupo);
        }
        return grupos;
    }
    
    public static List<Grupo> selectGrupoPorTipo(String tipo){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("Grupo","tipo_grupo='"+tipo+"'","",0);
        return preencherDadosGrupo(objects, 0);
    }
    
    /**
     * Seleciona os grupos que possuem horário de início entre horaInicio e horaFinal
     * VERIFICAR TIPO DATE E O SEU FORMATO STRING PARA O COMANDO SQL
     * @param horaInicio
     * @param horaFinal
     * @return 
     */
    public static List<Grupo> selectGrupoPorDiaHorario(Date horaInicio, Date horaFinal){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("Grupo","hora between '"+FormatoDataHora.sqlHora(horaInicio)+"' and '"+FormatoDataHora.sqlHora(horaFinal)+"'","",0);
        return preencherDadosGrupo(objects, 0);
    }
    
    public static List<Grupo> selectGrupoPorBairro(String bairro){
        List<Object[]> objects =  HibernateUtil.getTuplasDaTabela("Grupo","end_bairro='"+bairro+"'","",0);
        return preencherDadosGrupo(objects, 0);
    }
    
    public static List<Grupo> selectGrupoPorCidade(String cidade){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("Grupo","end_cidade='"+cidade+"'","",0);
        return preencherDadosGrupo(objects, 0);
    }
    
    public List<Membro> selectMembros(){
        List<Object[]> objects = HibernateUtil.rodarSQL("select p.id, p.nome, p.sobrenome, p.telefone, p.end_rua as end_rua_membro, p.end_numero as end_numero_membro, p.end_comp as end_comp_membro, p.end_bairro as end_bairro_membro, p.end_cidade as end_cidade_membro, p.end_estado as end_estado_membro, p.email, p.estado_civil, m.cpf, m.data_nasc, m.batismo_apres, m.usuario, m.senha, m.permissoes, m.id_lider as id_lider_membro, m.hora_grupo, m.dia_sem_grupo\n" +
"from pessoa p natural join membro m"
      + " where m.id_lider="+this.getId().getIdLider() + " and m.hora_grupo='"+FormatoDataHora.sqlHora(this.getId().getHora()) + "' and m.dia_sem_grupo='"+this.getId().getDiaSemana()+"'");
        return Membro.preencherDadosMembro(objects, 0);
    }
    
    public void adicionarMembro(Membro membro) throws Exception{
        membro.setGrupo(this);
        Membro.cadastrarOuAtualizarMembro(membro);
    }
    
    public void removerMembro(Membro membro) throws Exception{
        membro.setGrupo(null);
        Membro.cadastrarOuAtualizarMembro(membro);
    }
    
    public static Integer getNumeroDeGrupos(){
        List objetos = HibernateUtil.rodarSQL("select count(id_lider)\n" +
"	from grupo");
        return ((java.math.BigInteger)objetos.get(0)).intValue();
    }
}


