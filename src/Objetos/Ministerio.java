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
 * Ministerio generated by hbm2java
 */
public class Ministerio  implements java.io.Serializable {

     private String nome;
     private Membro lider;
     private String descricao;
     private Date hora;
     private String diaSemana;
     private Set membrosParticipantes = new HashSet(0);

    public Ministerio() {
    }

	
    public Ministerio(String nome, Membro lider, Date hora, String diaSemana) {
        this.nome = nome;
        this.lider = lider;
        this.hora = hora;
        this.diaSemana = diaSemana;
    }
    
    public Ministerio(String nome, Membro lider, String descricao, Date hora, String diaSemana) {
        this.nome = nome;
        this.lider = lider;
        this.descricao = descricao;
        this.hora = hora;
        this.diaSemana = diaSemana;
    }
    
    
    public Ministerio(String nome, Membro lider, String descricao, Date hora, String diaSemana, Set membros) {
       this.nome = nome;
       this.lider = lider;
       this.descricao = descricao;
       this.hora = hora;
       this.diaSemana = diaSemana;
       this.membrosParticipantes = membros;
    }
   
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Membro getLider() {
        return this.lider;
    }
    
    public void setLider(Membro lider) {
        this.lider = lider;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public String getDiaSemana() {
        return this.diaSemana;
    }
    
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
    public Set getMembrosParticipantes() {
        return this.membrosParticipantes;
    }
    
    public void setMembrosParticipantes(Set membrosParticipantes) {
        this.membrosParticipantes = membrosParticipantes;
    }

    /////////////////////////////////////////////////////////////////////

    public static Ministerio preencherDadosMinisterio(Object[] object, int index){
        Ministerio ministerio = new Ministerio();
        ministerio.setNome((String)object[index]);
        if (object[index+1] != null){
            ministerio.setDescricao((String)object[index+1]);
        }
        ministerio.setHora((Date)object[index+2]);
        ministerio.setDiaSemana((String)object[index+3]);
        return ministerio;
    }
    
    public static List<Ministerio> preencherDadosMinisterio(List<Object[]> objects, int index){
        List<Ministerio> ministerios = new ArrayList();
        for (Object[] obj: objects){
            ministerios.add(preencherDadosMinisterio(obj, index));
        }
        return ministerios;
    }
    
    public static void cadastrarMinisterio(Ministerio ministerio) throws Exception{
        HibernateUtil.persistirObjeto(ministerio);
    }
    
    public static void cadastrarMinisterio(String nome, Membro lider, String descricao, Date hora, String diaSemana) throws Exception{
        Ministerio ministerio = new Ministerio(nome,lider,descricao,hora,diaSemana);
        HibernateUtil.persistirObjeto(ministerio);
    }
    
    public static void atualizarMinisterio(Ministerio ministerioOld, Ministerio ministerioNew) throws Exception{
        String where = "nome = '"+ministerioOld.getNome()+"'"; //adicionar parâmetros para localizar tuplas (ou a tupla) para atualizar
        List<AtributoValor> valores = new ArrayList();
        
        valores.add(new AtributoValor("nome","'"+ministerioNew.getNome()+"'"));
        valores.add(new AtributoValor("descricao","'"+ministerioNew.getDescricao()+"'"));
        valores.add(new AtributoValor("hora","'"+FormatoDataHora.sqlHora(ministerioNew.getHora())+"'"));
        valores.add(new AtributoValor("id_lider",""+ministerioNew.getLider().getId()));
        valores.add(new AtributoValor("dia_semana","'"+ministerioNew.getDiaSemana()+"'"));
        HibernateUtil.update("ministerio", valores, where);
    }
    
    public static void deletarMinisterio(Ministerio ministerio) throws Exception{
        HibernateUtil.deletarObjeto(ministerio);
    }
    
    public static Ministerio selectMinisterioPk(String nome){
        Ministerio ministerio = new Ministerio();
        ministerio.setNome(nome);
        //return (Ministerio)HibernateUtil.getTuplasDaTabela("Ministerio", "nome='"+nome+"'","",0).get(0);
        return (Ministerio)HibernateUtil.getTuplasPorExemplo(ministerio, Ministerio.class).get(0);
    }
    
    public static List<Ministerio> listarTodos(){
        List<Object[]> objects = HibernateUtil.rodarSQL("select p.id, p.nome, p.sobrenome, p.telefone, p.end_rua, p.end_numero, p.end_comp, p.end_bairro, p.end_cidade, p.end_estado, p.email, p.estado_civil, m.cpf, m.data_nasc, m.batismo_apres, m.usuario, m.senha, m.permissoes, m.id_lider, m.hora_grupo, m.dia_sem_grupo, k.nome AS nome_ministerio, k.descricao, k.hora AS hora_ministerio, k.dia_semana, k.id_lider AS lider_ministerio\n" +
"from pessoa p, membro m, ministerio k\n" +
"where p.id = m.id and m.id = k.id_lider\n" +
"order by k.nome");
        List<Ministerio> ministerios = new ArrayList();
        Membro lider;
        Ministerio ministerio;
        for (Object[] obj : objects) {
            lider = Membro.preencherDadosMembro(obj, 0);
            ministerio = preencherDadosMinisterio(obj, 21);
            ministerio.setLider(lider);
            ministerios.add(ministerio);
        }
        return ministerios;
    }
    
    
    /**
     * Em ministério, considera-se que o lider já esteja cadastrado no sistema
 Verificar se usar o comando sql é a melhor solução
     * @param membro 
     */
    public void adicionarMembro(Membro membro) throws Exception{
        List<String> parametros = new ArrayList();
        parametros.add(""+membro.getId());
        //Parâmetros do banco que se referem à Strings ou chars, precisam de aspas simples
        parametros.add("'"+getNome()+"'");
        HibernateUtil.insertInto("participa_ministerio", parametros);
    }
    
    public void removerMembro(Membro membro) throws Exception{
        HibernateUtil.deleteFrom("participa_ministerio","id_membro="+membro.getId()+ " and ministerio='"+nome+"'");
    }
    
    public List<Membro> selectMembrosParticipantes(){
        List<Object[]> objects = HibernateUtil.getTuplasDaTabela("(pessoa natural join membro) join participa_ministerio on id=id_membro", "ministerio='"+nome+"'", "nome ASC, sobrenome ASC", 0);
        return Membro.preencherDadosMembro(objects, 0);
    }
    
    public static Integer getNumeroMinisterios(){
        List objetos = HibernateUtil.rodarSQL("select count(nome)\n" +
"	from ministerio");
        return ((java.math.BigInteger)objetos.get(0)).intValue();
    }


}

