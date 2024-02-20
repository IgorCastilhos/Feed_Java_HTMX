package org.example.postsspringhtmx.controller;

import org.example.postsspringhtmx.model.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class statusController {
    public static final int PAGE_LENGTH = 10;
    private static final List<Status> statuses = List.of(new Status(1, "@usuario123", "João Silva", "Acabei de saborear um delicioso café na minha cafeteria favorita. ☕️ #ApaixonadoPorCafé"), new Status(2, "@amantedanatureza22", "Amante da Natureza", "Passei o fim de semana fazendo trilhas nas montanhas, cercado por vistas de tirar o fôlego. 🌲🏞️ #Natureza"), new Status(3, "@entusiastadatecnologia", "Entusiasta da Tecnologia", "Novidades empolgantes no mundo da tecnologia hoje! Os novos modelos de smartphones serão lançados em breve. 📱 #NotíciasDeTecnologia"), new Status(4, "@leitorcompulsivo", "Leitor Compulsivo", "Comecei a ler um novo livro ontem à noite. Impossível parar de ler! 📚 #RecomendaçãoDeLivros"), new Status(5, "@gourmet", "Gourmet", "Testei uma nova receita de pizza caseira esta noite. Ficou melhor do que esperava! 🍕 #Gastronomia"), new Status(6, "@viajante", "Viajante", "Sonhando com minha próxima aventura de viagem. Para onde devo ir? ✈️ #MetasDeViagem"), new Status(7, "@amantedamusica", "Amante da Música", "Ouvindo o novo álbum da minha banda favorita sem parar. Pura felicidade musical! 🎶 #Música"), new Status(8, "@fanaticoporfitness", "Fanático por Fitness", "Treino matinal concluído. Sentindo-me forte e energizado! 💪 #Fitness"), new Status(9, "@cinéfilo", "Apaixonado por Cinema", "Noite de cinema com os amigos! Pipoca, cobertores aconchegantes e um ótimo filme. 🍿🎬 #NoiteDeCinema"), new Status(10, "@jogador", "Jogador", "Consegui um novo recorde no meu jogo favorito. Hora da dança da vitória! 🎮🕹️ #Jogos"), new Status(11, "@entusiastadaarte", "Entusiasta da Arte", "Visitei uma galeria de arte hoje e fiquei inspirado pelas incríveis obras expostas. 🎨 #Arte"), new Status(12, "@amantedosanimais", "Amante dos Animais", "Passei o dia no parque com meu amigo peludo. Cães tornam a vida melhor! 🐶❤️ #AmorPorCães"), new Status(13, "@vibespositivas", "Vibes Positivas", "Enviando vibrações positivas e sorrisos para todos hoje. 😊✨ #Positividade"), new Status(14, "@fashionista", "Fashionista", "Moda é minha paixão! Amando as últimas tendências e estilos. 👗👠 #Moda"), new Status(15, "@entusiastadacozinha", "Entusiasta da Cozinha", "Experimentei uma nova receita de sobremesa. Um doce sucesso! 🍰👩‍🍳 #Confeitaria"), new Status(16, "@aficionadopelahistoria", "Aficionado pela História", "Mergulhando numa maratona de documentários históricos hoje. Aprender é divertido! 📜📺 #História"), new Status(17, "@fotografo", "Fotógrafo", "Capturei uma foto impressionante do pôr do sol na praia. A beleza da natureza nunca decepciona. 🌅📷 #Fotografia"), new Status(18, "@buscadordeinspiração", "Buscador de Inspiração", "Encontrando inspiração nas pequenas coisas. Gratidão pelas bênçãos da vida. 🙏✨ #Gratidão"), new Status(19, "@jardineiro", "Jardineiro", "Terapia de jardinagem! Plantando flores coloridas e assistindo seu florescimento. 🌸🌿 #Jardinagem"), new Status

            (20, "@amantedacomedia", "Amante da Comédia", "O riso é o melhor remédio. Aproveitando um show de comédia esta noite. 😂🤣 #Comédia"), new Status(21, "@entusiastadaprogramação", "Entusiasta da Programação", "Resolver problemas complexos de programação é minha ideia de diversão. #Programação"), new Status(22, "@entusiastadoyoga", "Entusiasta do Yoga", "Sessão de yoga matinal para começar o dia com paz e equilíbrio. 🧘‍♀️🌞 #Yoga"), new Status(23, "@voluntario", "Voluntário", "Passei o fim de semana voluntariando em um abrigo local. Pequenos atos de bondade podem fazer uma grande diferença. ❤️ #Voluntariado"), new Status(24, "@fundadordastartup", "Fundador da Startup", "Construindo o futuro passo a passo. A jornada é o destino. 🚀 #Empreendedor"), new Status(25, "@amantedapoesia", "Amante da Poesia", "Colocando meus pensamentos em versos poéticos. Expressando as emoções mais profundas do coração através das palavras. 📝 #Poesia"), new Status(26, "@entusiastadoDIY", "Entusiasta do DIY", "Criar e elaborar projetos DIY traz tanta alegria. Hoje, é uma vela caseira! 🕯️ #DIY"), new Status(27, "@amantedapraia", "Amante da Praia", "Sal no ar, areia no meu cabelo. Um dia perfeito na praia! 🏖️ #VidaNaPraia"), new Status(28, "@ambientalista", "Ambientalista", "Vamos proteger nosso planeta. Reduzir, reutilizar, reciclar! 🌍🌱 #MeioAmbiente"), new Status(29, "@membrodoclubedelivros", "Membro do Clube de Livros", "Discutindo a última escolha do clube do livro com os amigos. Leitores, uni-vos! 📖 #ClubeDoLivro"), new Status(30, "@viciadoemcafé", "Viciado em Café", "Café é minha linguagem de amor. Um brinde a uma nova dose! ☕️❤️ #Café"), new Status(31, "@explorador", "Explorador", "Explorando novos lugares, conhecendo novas pessoas e colecionando memórias pelo caminho. 🌎✈️ #Viagem"), new Status(32, "@vidasaudavel", "Vida Saudável", "Comendo de forma saudável e mantendo-se ativo para uma vida mais feliz e saudável. 🥗🏋️‍♀️ #VidaSaudável"), new Status(33, "@criticodecinema", "Crítico de Cinema", "Acabei de assistir a um filme instigante. As atuações foram excepcionais! 🎥🍿 #CríticaDeCinema"), new Status(34, "@defensordosanimais", "Defensor dos Animais", "Cada criatura merece amor e respeito. Vamos proteger nossos amigos peludos! 🐾❤️ #DireitosDosAnimais"), new Status(35, "@observadorestelar", "Observador Estelar", "O céu desta noite é uma tela de estrelas. Encontrando paz no cosmos. 🌌✨ #Astronomia"), new Status(36, "@motivação", "Motivação", "Acredite em si mesmo e em seus sonhos. Você é capaz de coisas incríveis. 💪🌟 #Motivação"), new Status(37, "@chefemcasa", "Chef em Casa", "Preparando uma tempestade na minha cozinha hoje. Quem quer se juntar a mim para o jantar? 🍽️🍷 #CozinhandoEmCasa"), new Status(38, "@buscadordeinspiração", "Buscador de Inspiração", "Encontrando inspiração nas pequenas coisas. Gratidão pelas bênçãos da vida. 🙏✨ #Gratidão"), new Status(39, "@jardineiro", "Jardineiro", "Terapia de jardinagem! Plantando flores coloridas e assistindo seu florescimento. 🌸🌿 #Jardinagem"), new Status(40, "@amantedacomedia", "Amante da Comédia", "O riso é o melhor remédio. Aproveitando um show de comédia esta noite. 😂🤣 #Comédia"));

    @GetMapping("/feed")
    public String getFeed(Model model) {
        model.addAttribute("statuses", statuses.subList(0, 10));
        return "feed";
    }

    @GetMapping("/statuses")
    public String getStatuses(@RequestParam("page") Integer page, Model model) {
        if (page > 4) {
            model.addAttribute("statuses", Collections.<Status>emptyList());
            model.addAttribute("link", "/statuses?page=5");
            return "statuses";
        }
        var to = page * PAGE_LENGTH;
        var from = to - PAGE_LENGTH;
        model.addAttribute("statuses", statuses.subList(from, to));
        model.addAttribute("link", "/statuses?page=" + (page + 1));
        return "statuses";
    }
}
