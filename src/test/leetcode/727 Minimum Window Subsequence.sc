// Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W

  def minWindow(S: String, T: String): String = {

    val l:Int = S.length
    val lt:Int = T.length
    val iS = S.zipWithIndex
    val h = collection.mutable.HashMap[Char, List[Int]]()

    def checkChar(t: Char): List[Int] ={
      if(h.contains(t)) h(t)
      else {
        val res = iS.filter(_._1 == t).map(_._2).toList
        h(t) = res
        res
      }
    }

    var mat = checkChar(T(0)).map(x=>(x,x))

    for(i<-1 until lt){
      val t = T(i)
      var mat2 = checkChar(t)
      var laststart = -1

      mat = mat2.flatMap{ id =>
        val matched = mat.filter(_._2<id)
        if(matched.isEmpty) None
        else {
          val curstart = matched.last._1
          if(curstart>laststart) {
            laststart = curstart
            Some((curstart, id))
          } else None

        }
      }
    }

    if(mat.isEmpty) return ""
    val (from, to) = mat.sortBy(x=>x._2-x._1).head
    S.substring(from, to+1)
  }

minWindow("abcdebdde" , "bde")

minWindow("faalafealefelfafaleflflaeelleaelefafelflfeefaafaalleeeaflfaaeeleeallaaeeffffllalfafalfaelffffeeallaafeelfeelefelafaefafleeflfefeellllfffellleealflaaaellaeaefeaeeeealeflfafefafeeefellaalelllaefelefaeaallleealllealaleealfeeaaeaefeaefllaeefeaflaeeflaelllffeleleeeefeaaeflefllleefelfaeafeaaaaeeffaalflefleelaeeffleelffaeaeeaaleeaelaeaeeflafafelfaelflfllaealffealeeefafleaaflfelelalaealaaaalfelaaelflallefeaellelleeellaeaeaflaflllelaaeelfeaeeeelalffelefllaeeaaflaaeafeflflaeelaalaaaefefaaalfflaaeflfalefaefeffllaffaflffefeaellfalallfeelefeellellllaaaffalflaeleleeefellfaelfleealaaeafeafeaalflaafaaaeffellfflfafealafealeallfelaeafffeefaffafllleeeflaalafallaeaaaffefallallellaflflaalflaaelellelflaaaeeelffaalalealaeaeeleaafafflfaflefeaffalllfaelaaaaelffeealffffllaaafffeffaaaaaaaaaefllefeellaealalfallaffeffaafleeleelfeaallaleeealfeeflfflefeaalfeaaaaaallllaelfleefffealflaafffllllaaellfafefeelfalalaafllfaelffflleeafalflaealfefaelleeffelaaaaflelffaleaaeafallaaaaellfaaalfaalflefeaaflfalfaelllelealaefefeellaaeelefaelefefefllalaeaaafaaealfaaeeeleaalflelfalffffeaaefeefleeaeeelelflffaeleffaaffeealallaaaeelealeeeleaaaflflfllafelafeelfaaaefaaeffeefalfafffaeelleeleafeeeeaeeefalffaalfelaalealelafffalfelfallaaaeaafaflalealfeflafffeeelfalaaelaefeelefaleefaelfaaalfaleffellfefaaelafeeaaafaeffeleeaflafafeeaelfffeeaaaeeflafafelelaeeleeleffallleeleleelaeflffaelaaeelaafeleefaelleaeffflfflffeaeffllefleellaaallalaellelaefaellallllefffaefefefaefaaalefellaefeeealealeefafaeaaalaefeafllaffflalflfaaffffaleellefaffaefeelfllllaaeefallaafefeaalfeaelfaeleaflalaafafflflffffaflalefllfefleaefalelflffalfllaallellellllffaeefeffaallfeafafeelaeaeefffaellffffafaflefafllaeflflaaalalalealleflaeeeeleaaleffllaalaffefeflalalafleeleallaeeaaeaaaflleeaalaelleeflaelllaaaeflffefeealeeeefaaeeelalaealffaaeealfefeafeaafeaafleeaffleellaaellfalfeaeafaleelafallaeeflaafflfffaleelffllaffelleellefeeefllaealfllflfaeafaellaeaalalellaefaafeelflelllaaffalfeaaealflaaaaefllealllellllfefflalflffallfaafafafllaealllaellffalefafaeflelellffeefafefleelaeeeleeefeeleffflefalalaaaflfellflafeaelalaeflleallefalaffffafealllllleaeffaalleelaffeaffeafalafelfafaeefllfffellafallfefffalalflaeaallaffefllalflealeeelaallffflaefefafeaellleeflafaleaaefaelaaeafleeaafafflfaalelelfeaeffaellefelfeaeleeleeleeefalffaeeaaeeafelafleeeleaflefalfallffelafeleaalalllelaeeaaefaafflaffelefafflellaefeffleaelleffeafaefaffaeflfeelffaaffeffafaeealeeeeeflefeffealaaleleaallaelfafflfefaleaelefafffaeaalfelaeeffaelfeffaefflaaflaaaafelffefeeffeffeaflaeefllalelefffeflafeealaeelealaaaaeeallllaefelalaeffeeaaleeeefaaffaeeaffleeeelflaaellafaelfalellalfeaeeeelaefflaaallfefeeeellafefllflllfafeelfffefeaaffflafeleeefflalalfeeefaelaaleaallfffeflfealelaefaaealeafaffaffefffaafalaleefaafalelelleaeelflaefffaffeefelflaflefllfaafeeleleleffalalfelfafaeafeaaaaeelfllllafffeeelfelafealaflflflafafaaeeefaafeffefaleeelfeaefffaflllaealefaalaefaalaafaaelflefllafefaaaflfaeafleffaflfleaafaelaafleallfffalafaaleeeaeflaaefaelafefalfafalaefeffllalllleeaallaaffeeafaaaffllfaleaflaelllllffaeeaeaaaalfffaffelfaaaefeefaflfaflaaeealaleaaafeeelaeffeelaefaffaffaafaaffleflfalalalefalellaaaaeaffflfafaalelffeeaeaafalalafllaafeffefalfeffelfaflaafellffafeeaflalaaaaafeflllefefllaleeeeefeleaafelfefafffeffllllafaaafeefleaeaefflelfaffaefleefeelfalaflelaalfleeaeaafalaaeellfaelflfaeaeelffallllleeaeaeaffaaleeellaaelefleaalllaaflfeeafalfefllaafllfalaeeeefeffeeafleaflaalafalaleaaeefflalfleffalafeelfaaleeaeeefaaalefallleefffaaaaeealafeaeeleaeeelafflafelaafffaafeaffeefefeaaaeelffalleeefefefalfllafelalleefllaaleffflaelflfeaflfeeefafaelalllaaeelalleaafleflfeeaefelflelfeflllalleefafeelelealaaaaealfflfaeafleaeffllaleeaeeaaleaeaflafffelllaaleefeaflffllaaaflaleeflafaffealeelaeaeeaelfafeaffelelflaaallllelfeleeaaleaaffaeafeefellfaeleelfflalaaaffaeefallfeaaleaeflffflellelffeaefellaeflffellelflflalfefeaafllelaealaafaafafeffeleaaflfafefelefeaeefeefefafeaaaeaeeaealelaeflfaleeefllflflellealalaefeafaffelfealaeleeealflfafleafefffffaleaeaaelaeeaeffflllleeffelfaleefaalfealfflefalallaleelefeeflaafalffaflfelffafllelflafllfllafpopxorpproppprooxoxxoxrxoxrppppxroroorxrrxorporxoprrxxprporopxoxrpxpxoxroxrxrproooppooppprppxrorrxxooxrooxoppoprorprxpxrxoxpxorppppopxrxroooprxooxxxpxoropoxoxxxropprrpxoprrrooopppxppxrxpprpxoppprxorxorxoroxxrprrpppxrrxrrroxorpxrpooppoxrrpopoppxrrxoxorppxoxxrpxxxrprxrxooprxxprxrrproxrrrrpprpooorrxrxpprpropppooprrpxxroooproooxxoxxoxopoorpoxxrpoxprpporpxooxxxrxopoxpxpxorxorprxoxrxxorxprpooxrppxoxorppxxorpxxrxrrrpopxxoropprrproroxxrppporrrxoxrxroroorrppprpxropppxprororoppxprpxopprpprpppoxooxpopprrrpxpoxppppxxoorxporoxoxxppooxooroxxoxporxxxrprpppoxrpoprxxroprxxppporxrxrrrpopxxppxxxoxxopoxrrporpxpoopxxxxxopxpprprpxpproxxoroxppppxppoxpoxoprxpxrrpprxpxxrxxpoxpxxxxrorxpxxrorprrrorroxxoxxprorpprrpoorroxpxoxpxoopooxpppxrrorprropxorproxrxpprrrpxxoroporxxropxxxxooopxrrxproppprxxoooopxrrxppoxoxrrxooopoxpooxxooxppoxpooorpxxxpooxooxoopxxxporxoxxrprxppopxrrororxrxrxoxxorrxrorrxopxxprxxroxxropopxxorrxrrxpopxopporrxroopprpxoxororrpxororxxxxpopoxrrxrxxopoppooxpoxorxrrrorporxooppxoxoxoxxopxxoxrpxppppxrrprxoxrxxprxxxxpproopoooorrprpopoorprpoxporxpooxorproooppoxropoxorprrprxroropxrxrorpoorxxxprxooxoorrpxporxoooxxrxxoxpxrrxpproppprorroorxxrprxrorxrpoorprroooroxxrrorooxxoopxoopororopooxpoxxxpproporpopoxrppxxxpoxrrpoxxrrxororopprorooroxopoorxxpxrpxrxrxrxprxrrxxoxrrpoxxrrpxxoroxxrppxpxpxrpppoopprrxrrxororopxpoxxorrroprorooooorxxoxrxxoporropopxrrorpopoooxrrrpporpprpxoxxrppxrrorppxprpooxoxxpxrrproporrxxppxprxrrrroorrrxproxopxrorrropxrxoprporropoppprrrxpxopoorpooxprooooxroxooprrropxpxxxrrppxpororoorprroxrrrxppxppprropprroxrorroprxxpxxoxroopxrproprrpoxporprrrprpropxprrrrrpppoxpxoroxpxorprprxrprorrxpxrrorpxoxoxxorrroprroxrxpxrrppxporoxpooxxxxpxopooroopprxpoorprrpoopppxorrprxpprorxxorooppxrroxoxoopoxxppoporrxrrrxpxrprppopxrooppppoxoppxorxoxrxxoproxxpprrorpoppxrxpxrroxxorrrppproorroxrxroxxrroprxrpoprooppprxrpproprpxrrprrrpxpxpxrxrxrpxpoprxoroxoroorrprxxrpxpoppxoporxxrxxxopxpoxxppoxooroxprxrrppxpropprpxpppororrxorooxrororrrpprppopxoorprpxrorrxxppoopxopoooropoxrrpprpxxppxprproorpporpooxoxrorxropppxoxoorpxrrrrpxropoxxxpoxoooxppxrxxroooppxrrpppooproxprororrxrorpprpxrprxropppoorxrprorprrorxxooxoprorpporppoopxxrxxpprrppxpprroporprroroorpprooooxoxpprrrpoxpppprxoorooooprpoororoxprxrpxxxrropprooprrxrorrorrororxxprproxrxxxoxpppoppxpoprporxxpoprrxopprxrxxopxooopporpxrooxxrpoppxrppxoxrroprxppxrxrxrppxopooprooooorpoxopppooprxoxrpxorxxproorporroxoxxxrprxppooorprxxxrpooxopporxrpororprpppxprxorxxororpoorpporxrpopxropxxxxoorppxroooxpoorrppporxpxxrrrpoxpxoxprpxrorroxxxxxxoxpoxpxprrrxooppoprrxrropooprxxxrprxrxoxoroxrpppopxxrxxxxoorrppporxooopopprxrporpprpprrppppoxoxrororpoopxxrorpppoxxrrxooorxrroxxoxoxooxorprooroxrppproxxpxrorpxxprroxxoxprooxpoprrproprrxrpxxoppoxprrroxxpooxrprproxoxrppoxpprxrxxrrorpxopxroroooxroorxxoooxxxprrorxorooroxoprpprrxxroxopoorpxpopopooxpopoopoppoxxoooxxrporprxxxrpxxoxppporxpxorppoprxrppoxpoxopopxpxorxxxooorxprproppooppoooxxppxrpprxpprxpporoooxrrxopoorprppxopxpxxpppproxoppxorrrropoxpooroxpxroorrpoxrxrxpxpoppoxrppxrrpxoporopppxpxoxxppprrorxrrxopxrorooorrrxrrppropprpxpxropoxporrroppxorrxprpxpppoorxoprrproxrooropxoprprprpxppppporrxpoxxrrppxxxoppxxpxxrrproxpoporororrrroxoprpxooxprorropxxrroxrxooxrxxxorxrprprxrxxpxororxxpoxoxopoproppxpxrprxoooxooxrprorxoopprxoooxrrxopprxrxxoppxxoxopoprxxrxoxxxorpooorrxropxoxprpxpopxxpxoxoprxxporopropxorrorpporropopxpxxrrooooprorororrroooprooxorxppoxppxoopoxxoppooxopxrxpxxpoooopppooxooppxrppxxxxpoopoxxoprpoxpprproxpxopprpxxrxxxorrrxxpooorrrprrprxorrxoppopprxxoxxprxrxroooxrorpropxxpxrxorxrpxxropxxoppprrxpoxxxrxxxporpprrrporprpxpxroprrpopxxorpxxpprxooxxorxopxpxppopxxopxoroorxrpoxxrxpooorppopoorxxrppppoorxoxrprxrxopprpxxpxpoxxroorxoppppooxoppoxrrpoxoxxxopooproroprppxproxoxpoxpxpopxoorrpoxrooppxrpxooxxxxrrprooopoxrpxxxxprrpppoppprrporopoxrrprprrpporopproroprooooproxrrxpprpxoxopxxrxprppxxoxxooxpppxorrrpoooopopxxrxoooxoxxrrrprooooopoororrprooxorrxooxopoprrxxrooxrrpproxpxooporxprxxpxpprxproxrxropxpxppxprxrorxroxrpxpopppoxxroropxoxopporpxoxorrppppxxrrorprrorrprorpxpxpppoooorroxrxrporrrxpxpoxxppxroprxpprorrxoroxrrrroppxxopxoropoxxpoxopxssllmmslsmssmallssmsalalmmmslmlalmsssllmasmlmssammaaamlalaalmsammlmasamsmammsssamalalmasssmlasaalsalsllasaammmmsslsllllaamlllllamlslmlllamlsmlallllallalaalsmmlaaasamssmamlamslammsmssalaasmaaaamsllsmllmlasmmmlslmlmsalsllsmlmsaallsaaaaslslsmasalmssaasaamslllmlasmallssslalsaaaasllslamlslmmlassmlaammmmslssmlalamaaalmalssmlsllmsamaaslaslmmlmlllmamlsslmmlmaalalsssmmsssammaalmmaammmllllasasamsmlalallsamllsalsllmssmalmsmlamsalslmmslassalmlaasamamsamsalsllammmmsalsmlsalmlllslsasmalmslsslslslslssmmaasassmssmmlsasmsmllaamlmamsassmaslmsmalaaalsmaamssssamsmmsmasslmsmmmlsaaamlmsasssmllssslalamlasmlasssmsmmsalsmssmsmllslalmmammsslaalllsmllmmmlsllmammmlamlaslsmmasamsamlsamssmalmsmslmlassmmmmmlmmslsalsllaaamalaslamsmamsssmasmammmllamlmaallssmmsassallmlsalamlalsmmlsaasllmlalmmmslammamsalsallslamlmsmallmmaaasmasalmlslmlsmmmasaamalsalaalalmsaammasmmaalssmmaasssllmamlmsssallssslmlmamlllsalammsmamaammmlasmmamllmllmammammlamlslammmllllssllassmmsmaslasssaassslmllmlalmllalmaaaamalmlsaalsssaamamllmamsammssssaaalsmaaamlmlsaassalaassslsalalsmasamaslalslalmasllssllaallsssalasamssmsalallaammlalmmmaammalaslmmlsamlllmsmasamlmaammmamalamlsllamlmsmmlllasmasmalaaasslmsllmlmmllsasmllssmllsmlssmamslssmmamsmssslsmlsmllllmaalsmmalalslsasmmamsmssalaasmallmsllssmlaslalallmassssamsmmalmasslssaaalslmsllsmmmssalmlsslaasmllmmlaalmsmlaassaslsmsmlmsslmslaasalmasslaslamasmmsmmlllsalsmmmaslalmmlaamalalslsalslmaslsslasalllmmlamamalmasssllasmlassalllmsmmlsamsammslallmssssamamamaamlmssmassmslammmlmalssllmmslmassllsmmaaslsaalmlaamaalsmlmaammmlsmlassmmlmmmasmasallmlalassasamslsaalsmsammalmlamsmllsmmmmasasllssslassallmmsmasaaalasllmlmsllsammmlasmlsammamaaaslsmlsalssllalsaamalmlsmaasaasmlaamallamlammsslalaslalsallamlmamsalmmaslsmaalsmllaasaassassllaasmsslamlllmmssslasllmsamallassamsmmsamlmamaslsaalsmmlsaaamllallaslsamlsalaasalassmlalsllmlmaslammallasaammsamssmlaslsmslalmlmlsaallaamalalslmmssallmlmsslasssmllslalaaalaasasmmlmamaasmsmsmamslaasalaslmaalsassaaalmlmmssmlslalslmlmlaasalsmssmmlmmamllaamllamlsmsslamalamlmsmmmamasmamllslllsallasalslmsssasaaasaaalmasllmamssllslsmasallalalasmlsmmsalslalllmlssallaammlmlllaasasslalllsslmmsmlslammlamlmamasmmammsalmaallssallslmsmlamlaallalmaalllmalmamlllmlasslslmmmamllsmaaasmsssaasasssmaamsslmssmlmlamlmsamlaalllsmlsmaasamllsaasmmslamsmsaalalmlaasmsaaamalssmammsasllsalslalasmsssmamasllsasmamalaamasmslsmmlmlmlalamlmalmssmmammmasamlllmaalmasllslalalmlaaamlamsmmaslaslmlsamlalmmsmmlsmllllsmlmmsmssmsllssmsamsaaamsmlasslmmmaslallaaamammmallmmaamlalmllllmmmmmlmmassalsalalasammammlllmlmmsalmmlsaasmsallaamalaaamsmmamsasmmsslasmmmaaasslmlmllmmslllalslllalsaaaasslasmsassmmasmlalmmlsllmmlslslaalsassssalmssaasmsaamssslslmslmmsmssssasmaaslasslsmmsamslsasamsaaalsmallmsmsalllssammalalmaalsmlllslmssmllaamalslaasmssamlaalassmssmsmaamsaalsmllmsssalmaaammmslsalmlsaslslsmaamammmasssssamsamllamasmlsaslmaallsallmlsaammassamslsmlsamaamalsalaslaaslslsllmsalssllasasalllmaaammalassmlllamlsaammslmasamaslmaalassaammlmmlalmmalsmmlmsllsslmlsmmslllslsmlaassmsallmaaamsmaamaammmlallsssmlsmsssmlsasmlmlmssaalammalalaammsmssslsamsmmslalslmssmmsammmaalmslllsalslasallallalalsaalmmasamllllllmaslmasmllssssaamaaamllalmlllaslamslsmmsammmlmsllamslasllamsllamsasmlllalmmlmmslsallsslaalassamssllasmslamssmmmalsmmalalalmmslmslaamassmmslmsamlalmmamlmmllammamasamllllmlaasslamlammalamalasslsaamlammssllllsllsmaasaasalsmsmamaslalasasmmamssamsllslsmamsmsslmmsllalammaamlmmlslsmmsaaallmsslslamsmlamlalasasassssamaamaamaammalmsmssalmssmmmaslssmaamlllsslmaamalmlsmsmsslasalmaaamsllmmamsamllmssmslaaaamasmlsssssamaammlsmlsassaalsalmlmalallmmllsalmlmmlsmmmssmaalassllmamasammlamassmsslamalmssammmsmssallmmallllsasssamsaaaamsaalsalaammsmaamlssaslaslllamllmmlmsammlmaaalmsmsamaasalsaaamalalsaaalalslalmaamasmmmlslsamlsamalalmmmmsmamsaaalsammmslsmsmmsmamsmsmmsmmlmssmslasmmmaamslsmmsllmsamasammmsamslaalaaammmsllmmaslmmlaslsssslmlmmssaslsssmalasaslmsasslmaalamsallasmllsslsalmsmaslamaassslsssmslalssmalaaasammasmlslammmmsllmlmsmsammamslmsslsmsasmsslasssmmmaslsmmlslsllssslassmmmsmlsmsalmasmasllallllalasslmmaaaammllamamlmllfftfffhkhkkffhfkkffkffttkkkhktktkktktkfkttftkkhkhthfthkhktttkfhfhffktkfhtfktthfhhthfkhkkffkhttkftfkhkthhhthkftkffthktkkhkftkhfkfktkfhkftkttkfttttkfkhthhftthfkkfkhkthkfhtffktttttttfkkkkfhtkthtfthhfhtkhhhthffhhhfhhhfkttkkhtkfhfkfhfhhhkhkfkfhkhfkfhhkkhfkthhfftfffthkfthkhhhtfhkhttfktfhhkhhhfhhfhfftfhhhfhttthfkfkftttkhffhhfktkhkthtkttkkhthkfffhfhkthhthkhkhkfkttfhfthktktftkkhfkkfkttfhttfttkkkkhhfktttkkfhkfkhktftktttktkhthktththkthfhhfthfkkhhhkffkhhtkfkkfhhkhkfhtfkfthkkfkfftkfhftkhkhffhhfttkhtkthttkfttthtfhfkfkkhfhhhkttffkhtfffhkfkkhfkhkktkhftfffkkthtfkfhtthfhhfthkfhfttffhfkffthttftftkfkhfkkkkfkktfhkffhfhkffhhhhfhktkkkkkhtkhhhffhhktfkkthttffffhkfthhfttkfthkhhttttfttfhttttkffthttfthfttttthtfkftttffthfkkfhffftftkkfktthfhffkthkftttkhkhthtfhhfkhtffhttkkkhkfthfkktthfhttthkhtthkfhtfhhhfhktffkthttthkhhhtfffkhthhkhhhkfhthfhfhkhhkhhtkfththhkffhfffkkfkfhfhffftttftffhththfthhthfhffkfkkkfffkhkhttfkkthffththffkhttfthkhkkthkftkkfhthhttttffhfhttkhtkhtffffhfkfkhfhkthhtfkhhttfhtkkftfffffhhffkhkhhtfftfhhtfhttfhktftfthhhttkkhhkfftththfttkfhhkhkhtkkthkfhhhhfhtttktfkfhkthtthhhkkhfftthtthtfffhhhftkkhfkhhkkhhkthkkhhkhktkkfttkhhhftthffffhhtktktftkhtkhkthkftfkffktfhtkfhhfhtktttttffhkfhkhtthtftkhtthkkkhhtkthhfffkfhhfkttfftktffhthftfthktkkhfthhfhhtkhkfhkhhthhfkfftffkkktkfhthkhkhkhhkfhhhfhffffhfhffttfftfhkthkfhthffhhthhfhtftkkkhhtttkkftkhhtfhtkhtktfttkttkfhkkhkthkthkfhhkthkhfthkhtftthhkfhhktfkkfkktthkhfhthkthtkhkfhktktkhthfkkkkttthtkfthfhffkhfftftftkkkkkthhkftfftftkthkhhfkftfhkfttkkkkfhththtttkftkfhttfhffhhhkhkhhhtthkkffkktkktkftfkfkfffkfhhkfhffkhtfkffkththfffkfffttkfkhtttkhhkttkhfhffkhktthkththkfftkfhkhhttfhtkfhhttkktfttfhhtffkthtkhthhffhthfkftfkfktftkhfftthktkthkthhtkhkttfthtffhftthtkkthkktthhtfkffkkkhhfffthhhfkhtttffhhhtfhtfffttkttthfftfthtthhkthfhtfhhttthhtkkkhkkhkthhffhkhtkkffhffhhtkffthhhhkkktfkhtffkthffkhhkhtkhhhfhfhkkkkhkhkkfthktfktfhhhthttfhfhhkkhfhffhttktththfhkhfkhhkhfkfftkkhttkkhfhfkftffffkkkfkffthfkhhttthkkfktktfktktfftthfftkfkhtkthkfkfftkkhftthkttfhfhtttfhhtftkththkkththfhfhfkfkhhfkhhtfhhkffkftttfhktkkffhfhhhhkthkkhhktkhtthfkfhkkffhffhhhfkkhfkthkktffhkfthhftttkkthhftffktfhhhhttttfthttfhtfftkkkhhtthftkkttfhftthfhffthkkkftkhkfftfkfhktttkfkhftfhtththkttfkhhkhkkhhfhtttkkkfkktkfkkhhtffkhffkhttttffkttkhfhftffhtthhtkffhhfkftkhtthkhtkfhffttkhkhkthktffkftkfttthfhfttkhhkhkkhkhhhfkkkkkthkfftkkhhhkttthfhtffhftfthfhkfffftffhkffhhtffktfhtkfkffffkktftkkfhtktkththftkhfhkkthfhffftkftffkhtfkkkkkfkkfftftttkftkhththkffhtkkttktttkhkfkfkthhtkfkkftfhkkkfkhhfhhtfkhkkfkfhhhfttfhhfkthfkhhhttttfkhhtfhftffhthkkffthfththththffhffthhthtkhfkhthhktkkkhkhhkhfffkfktkttfhkkkthfhfhhfthhkthhhhtfttkhkffhtthftktftttktkfhthhhkftfhhhftkfhhkhkhtfffhftkfhttthktffhhhhttfftthhhhhhtffhttthkkkfhkhhkhhkfftthhtkhhfkttktkffkhhfktttfhhhhthkkhfkfktkhhkhkttkkhhthffkfkfhkfhhftkhtfftktkfkfftfttthhttftfhthtfhfthhfthffhtttkkkhkftfkthftfkhtthkhfhhfkfkkhfkkkftfkkkhhkkkktkhhttkftthhfftthtkfhthfktfffkttkfffkthfkfkhtffhhhfhhhftkhhtfthkhktkththkfhkhtkhfktkftkkhffhhhkfkktthftfttfkhkkkfhkthhhffhktttffhfkfhtkkfttktkfkfhkhftkkthtfhfkkftftkffhkftfhhhkkfhftftkftkhkhhftkffktktftfhhkkfhffthtkhffffthtftthfkhffkkhkkftfkkfhhkhftfkkhffkhktkkfkfkthttkkffkthttfftkfthffhkttkkhtfthfkfthftfkffkfkkhhkhffkfkfhtktkfkkffhkkkhtfttkfhkkhtktffhkfhhkhkhhtkkhhhhktkhhhthkfkfkftftttttthkhkkkftthhthhfthhfttfthtftkkkfhffkffttkffkhtkffhffkfkhfthkhkfhkthkhhkttffftfftttkhthftktfhhtkhtkhtfffhkhhkfttfftkfhhttthftfthkkhtkkthtfkktkkfhhfhffhkftkffkfhkthfftkffkhtffkhkkfkkkkhfhfthktktktkhtfftkfhkfkhfhfkktktkthfftkhkfffhhhhhfhhtfhfthffkhkffkhhthhhttkhhkkthhfkkfkhkfftkttfkhkkfffkktfhfftktthhffffhthhtkfffthtftkthfkfktktktttkhkkkfhhtktktfthffhktkttktfkttkhkhkffthfkfttththhfhhhtkttkfkthfktkhftthkkkkthkthtftfhkhhhfthkthftkkkthftfkkkhffhkktffkfkhtfhftffhhhtfthftfkkfhhhkffktkffhtkhkhhkfttkktkfkftkhfhhhtfhtttkkhtttfhkkffhffttkffhtkffffhfthftffktkkttfhttkthffkkthkffhkffftthktfhfhftktftffkfkhtftkfhhkhkhffhhftkfktftkfkthkkhhtfkkkhhhkfkhkhhkkthhkfhtffftkhkttfktthhhhffthkkkhkftthttfhfkfktfktfkttttkhfhkftftftktfthhfttttkffftkfthhfttfhthkkkhtfhhhktkkkhffthkfhtktffxccdzxczczzzxddxxxxxczdzdddccxdzzzzxxcddcdzccxxzxzccdxcdczxdcxxczzdxzddxxdzczxczcxxcxcxxccdcxcxxdxxxzdzzcxdxxzzdcxzcxcccxcczcxdzdcxcxxxzxdzcdzcdxxxdxcccxxxcdczzdzxxcxxxzzxxczczzdxzzxcxzzczdcdzcdcxxcxcxxdcdzxcccdxzzzcddxzcdxxcxddcxcccxzzcccddcdzzzxzcddcdxcdxzdxzcdcccddxzdxxczzcczcczccczczdzdxdxzzddxcxxdxzczdcxzdcxdxzddxzzxzdzddzxzcddzdxcdcdzxcdcddcccxxxdxczdxcccdzzdxdxdxczzzdzdcxzzxcdzcdzzzdzzcczdczczxxcxzzzxzccczzxzdzczzxczcxzxczxdccczddxxxccxdccdxdcdxzdzcdczdxddxdcxcdcxdxxxzcxdzzczcdxdxzdxdddxxxzzccdczxxxzcdcddzzzczczxxcxdcdcxzdzdxdzdzzzxcxdczzcddxcdxxczzcddccccxzdzzxcdczcxcxxxxdccxcdxzccdccxzzxxcxzzzdzccxzcddcxcxccdxcdcdddzddxzzxczxxdccdxxxccczdzxxddxxdczcxzzxzdcxdzxzxcxzdczdzxzzzxzccccczzzcdczzzzxxcxzxczcxzxzxzddxcxdzdcddxzdcczxdzcdczzzccxcccdzzddxxzdccxxzxcxxcxzczxdzxxcxxxxcxdcxdzdzzzzdxzdcccxzcccxxccxczxcxxzdcddxdczdxxxczzcddxxxxcdczdcdxcdccdczcczdzdxxczzdczcxzczzczzxczdzzzxzzxcdzxxdxdzccdzdzcddzxcccxcddxzzzzzzzzcxzcdzdxzdccxcccxcxdczzcxxxxcxxcdxdzxczdxzdccxcxzzdzcxzxczxzxccdzcxdddcdcdzxzxxzdcczzdcxcddxxcdxdcdczdxcxzxxzzdxzdzzdzxcddxdcddxcdzzzzxzdcxzxzxdcdcdzdcdxzccczxzzzddxzzdxxcxdzxcczcdcdzczxzdxczxcdzdzddcxxxzddccczxcccxddczczdzcxdcddzzxddzzxdzxzdccxdxcxczczccxzdcddcddzzdxzxczddzzcxczxxxddczxczdzxdxzzddzzxzzccxcdxzdzcxzxdcxdzdzzxdzdzdzxxcczcxxxzccdcxcddczxdddzzzcxdzzcdcdxzczdddxdxdxzczddzdxczcxccddcxxcdzcczcxczcxzdxccxzzxdxcdzczzcdxxdcdzdzzccczddccdczdczcdxdxxzdzzccdzcdczxzcxxxcdzzzcxcxczczzdxxdcdzxxcdxcxxzxccdddccxxdccddzczzzdxxddcccdzdzxxzzxdzzzxxdccxcdcddzdxxzdccxdzddccccdzxzdxcxdxczczcdxxczxzcddxcxxcxdxxzxdzcxdxzxcddcdcxdzzxzcccccxzzxdzzdczdczxxddzzzdzdzcddxczcdcxxxdzccdxxxxzcxdxdcdxcxxzxcdxxxdxzdzxczzxxxdcdcczxxzdzxdccdcdddddczxzxxczcxxcxcczddcccxcddcczzczddxccccxcxccxdccccccddczzdzzxxxddzddzcxxdzczdxddzzxzxzxzdcxddzzzxcxcddddcxczczdxddxczcdzdxzczdzxxcxxzcdxdxzczzccdcxzdxzzzdczzxdxzzxczdcxczdcxzzzcxdcddddxxxdccdzdcxzzcxzczcxzzdcddczczcccdcdcxxcxdddccczcdcczdczxddzxdddxccddxzcdxxxdxccdzdxcxdxddxdzzdxdcdcccddxzdczccddccdczczxzzdzxzccczzxcdddzdddcdzxdzccxzzcxdzcxccxcddcxdzdzccxdxxzxcxcdcxdzdxzccxxdxdcdzxxdxdddzcccdzzcdzdcdxczxdczczdcdczdcxxdxcxxzxzczxzzdzdxzzcxcxczddxczzxczzcdxczzddcdxcxxxxcdzczxczdzcxdxddcddxzdxdzcxzccxxdcxzxcdzddxxxdxxzdcxdcxcccdzxxzzxdxczdddxxxczdxzxzzcdxzcczxxccdxcdddxxdzczddxdcczzdzcdzzzcczcxcdccxzzcdxcxzxxzdzcczzzczddccdzdxczzcczcxxzczxzxdxzxczcdzdzxdcxzczzczcczxdxdzdcxcczzzcddczzxxzdcxxxzzczxxccczxdczdxcxxxdcxzdxcccdxzcczdxczxddxzddxdzxxdddcxxdxdzdxczcxzdcdzzddzdcddcczcxzcdxdcxcdczczcxzcxdzczcdxzdcxccxxzccdxzxxcdczdxzxczzxzxxcdzczzzcxzxdxzxxzdzczdzcczxcxzczdzddcxdcxddxxdxdzxxccxxxzcdddxddczzddzzddzxdxzzzxzxzxcccxxczdxcdzccddzczzdczdcccxczddddczzcdzdddxzccczcxxddczxzcczczddddcdzxdcdcxxdzzzzccxccdxdcxdxdxzzccxdczzdxczccdcczxzxdxcdxdzxzxxcccczxxdzzdzccddcxdzzzzxcxxxddzzzdzdccxdzxczzxdzxxddddcxzddzzxcdccxxzccxzcxzxddccxxddcxdxczxxzdzzxcddzcdcdzczzzdzzdxccxcczzczccxcczzczzcczzczdzzdczdxdxxdccxcxxxdzddxdxxzzxzxcdxxdxdcxxcxcxzdxczdcdzdddxdxczzdzdzzccxzzddcdzddxcdczcdxccczxxxxczxdxxxcxzdczxzdczczxdxxzzxddzcxdccdcczdzxdzzxddcdzczzddczcxxczccczxxczczzzxdxzdxdzdcxxzdxccddzdxczdccxxxdcczdzzzdxdxzdxddxdddxxcdxzdxzcddcxzdcdcdzcxzxdcxcdcxxzdczcxdcxdczcczxdxczczdzzcxzdcdxccxczdxcxxdzzdxczzdxzdzxddcccdccxxxcxzdxccccddzzdcdxccccddxcccxdzzxxczxcdxddcdxczdzxzxcczxzzzzcxcdcczxddczzxxzxczdxzccxxcccxccddcdxcczcxczczxcxcdcdcdzzxzxdxzxcdddxdzzxzxxxzzxzzccdxxdddxxdcdczzdccdcxxcczxzxxczczzxxcxcczzdddzdcdxzxddcdxcccdzdxdccxxcxxdxxxdczzzcxxcdcxxdzxxzzcxzzcdxcxdxczdcdzzdcczcxdczdzxzzxccxxdzdzdzxdxzcdzzxcxdzccdcddzddzxcdczdccxdczxzxxxczdxxcxdzdddczczzxzdxcxzxzczzdxzdzxccccddxzxxxzzdccdzzcddcxxdcxxxcdxxzdcdzzzzddzdcxxxzzdzdxcxzzzzzxcdczzdzxdxxdcdcxxzzdxccczcdccdcxzzzccddcccxzxcdzccccxzzcddcdcdcxzxdzcxddczxcdzdddzcdxcxzxxccczzddccczccdddxdzccxcddzcdzzzxxzcczxcddcdzczddzdxxxxxccczczxxxxxccdcxczzdzczxcxdxzdxxzzcccxcddzczzzdxdcxxxzdxccxzcccdzcxxxcdxcxzzzcdxdzzxxdzdzcczczzzzcdzczzcxxcdcccdxzdzzzzzzcxczxcczdzxdzcdxzdcdcxdxczzzzddddzcdxzzzccdzzxxcdxzxcczzxzzccdxcccxxcdzdzzzzxxxddxxdcxxzxcdxzxxdzdczxxxdcdxxxxdzdxxcddczdxzxcxzxzcxzcz","aafexpporasshttkzccdxx")