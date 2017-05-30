package com.objis.demojdbc;
import java.sql.SQLException;
import java.util.Vector;

import CommonClasses.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		DataBase db = new DataBase();
		
		//System.out.println(ProcessRequest("intitulecours;HLIN101", db));
		
		//Création cours video
		/*System.out.println(ProcessRequest("creationcours;Cours vidéo L1 info;HLIN101;video;9qY-UYjvP0s", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo L1 info;HLIN102;video;vzh7DLWJGa8", db));	
		System.out.println(ProcessRequest("creationcours;Cours vidéo L2 info;HLIN201;video;_UM3I4lY448", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo L2 info;HLIN202;video;g9ePHxNq0Sg", db));	
		System.out.println(ProcessRequest("creationcours;Cours vidéo L3 info;HLIN301;video;6et7DkVUrSU", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo L3 info;HLIN302;video;bQzpJnm9M4s", db));		
		System.out.println(ProcessRequest("creationcours;Cours vidéo M1 info;HMIN101;video;Xsn-VBJqUM4", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo M1 info;HMIN102;video;706tS6pW0BA", db));
		System.out.println(ProcessRequest("creationcours;Cours vidéo M2 info;HMIN201;video;h2YpG4CF860", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo M2 info;HMIN202;video;dZc8ZW9dJpk", db));
		System.out.println(ProcessRequest("creationcours;Cours vidéo info;HIN1;video;bGeZS7OwqYk", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo info;HIN2;video;oW6JxkAYhYc", db));	
		
		System.out.println(ProcessRequest("creationcours;Cours vidéo L1 bio;HLBI101;video;Kx7x3XCJWwE", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo L1 bio;HLBI102;video;UrdPaxfrbqs", db));	
		System.out.println(ProcessRequest("creationcours;Cours vidéo L2 bio;HLBI201;video;muLu_W6ghh0", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo L2 bio;HLBI202;video;05UL3HuGoyQ", db));	
		System.out.println(ProcessRequest("creationcours;Cours vidéo L3 bio;HLBI301;video;yIQ9oKZ7VxI", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo L3 bio;HLBI302;video;eR1-K9Zx7Tk", db));	
		System.out.println(ProcessRequest("creationcours;Cours vidéo M1 bio;HMBI101;video;BxZSeWZyt4k", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo M1 bio;HMBI102;video;1Tnq6CJM7ME", db));		
		System.out.println(ProcessRequest("creationcours;Cours vidéo M2 bio;HMBI201;video;k3lvSCZ98uk", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo M2 bio;HMBI202;video;2_ebwFs", db));
		System.out.println(ProcessRequest("creationcours;Cours vidéo bio;HBI1;video;9nMI1z6qun0", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo bio;HBI2;video;S7ACIF34yQY", db));	
		
		System.out.println(ProcessRequest("creationcours;Cours vidéo L1 math;HLMA101;video;vOLZ8wLWIbY", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo L1 math;HLMA102;video;rLFUnCUyPko", db));	
		System.out.println(ProcessRequest("creationcours;Cours vidéo L2 math;HLMA201;video;ur9smWN2HFg", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo L2 math;HLMA202;video;qrpp1Mh8EDo", db));	
		System.out.println(ProcessRequest("creationcours;Cours vidéo L3 math;HLMA301;video;TVW8UBTmT58", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo L3 math;HLMA302;video;PKMVD7bD4cE", db));	
		System.out.println(ProcessRequest("creationcours;Cours vidéo M1 math;HMMA101;video;vlFWMeBUTXo", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo M1 math;HMMA102;video;dLwi_opxLxs", db));		
		System.out.println(ProcessRequest("creationcours;Cours vidéo M2 math;HMMA201;video;gFpLfhXjLSY", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo M2 math;HMMA202;video;I1xM1bicp4U", db));
		System.out.println(ProcessRequest("creationcours;Cours vidéo math;HMA1;video;_AS7bwOsxd4", db));	
		System.out.println(ProcessRequest("creationcours;Conférence vidéo math;HMA2;video;fFXSUpW50a0", db));	
		
		//Creation cours pdf
		System.out.println(ProcessRequest("creationcours;Cours 1 L1 info;HLIN101;pdf;https://lipn.univ-paris13.fr/~dubacq/pdf/m1101/sys.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 L1 info;HLIN102;pdf;https://www.lri.fr/~antoine/Courses/AGRO/TC/Cours-1A_SIx2.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 1 L2 info;HLIN201;pdf;https://www.nimes.fr/fileadmin/directions/bibliotheques/informations_pratiques/Diaporama_initiation_informatique_nimes.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 L2 info;HLIN202;pdf;http://www.fsr.ac.ma/cours/informatique/elbenani/Partie1.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 1 L3 info;HLIN301;pdf;http://www.fsr.ac.ma/cours/informatique/rziza/cours/Introduction_Reseau.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 L3 info;HLIN302;pdf;https://www.enseignement.polytechnique.fr/profs/informatique/Francois.Morain/TC/X2003/Poly/polyX2003.pdf", db));		
		System.out.println(ProcessRequest("creationcours;Cours 1 M1 info;HMIN101;pdf;http://www.bdaa.ca/biblio/apprenti/formatn/guidform.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 M1 info;HMIN102;pdf;https://www.ibisc.univ-evry.fr/~hutzler/Cours/I11_InfoGene/Cours/CM1_HistoireInformatique.pdf", db));
		System.out.println(ProcessRequest("creationcours;Cours 1 M2 info;HMIN201;pdf;http://www.pqs.ulg.ac.be/attachments/divers/Intro_info.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 M2 info;HMIN202;pdf;http://www.ensiie.fr/~guillaume.burel/download/compil.pdf", db));
		System.out.println(ProcessRequest("creationcours;Cours 1 info;HIN1;pdf;http://www.ai.univ-paris8.fr/~jm/compil.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 info;HIN2;pdf;http://www-igm.univ-mlv.fr/~forax/ens/java-avance/cours/pdf/old/I-%20Le%20langage%20Java.pdf", db));	
		
		System.out.println(ProcessRequest("creationcours;Cours 1 L1 bio;HLBI101;pdf;http://www.fsr.ac.ma/cours/biologie/triqui/M%20TRIQUI%20COURS%20DE%20BIOLOGIE%20CELLULAIRE%202016-2017%20.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 L1 bio;HLBI102;pdf;http://www.fsr.ac.ma/cours/biologie/sbabou/Cours%20transcription%20S5.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 1 L2 bio;HLBI201;pdf;http://www.remede.org/librairie-medicale/pdf/s9782100564255.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 L2 bio;HLBI202;pdf;http://neurocomp.univ-lille1.fr/Cours%202011-2012/cours%20%20bio%20cell%202011-Etudiants.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 1 L3 bio;HLBI301;pdf;http://fac.umc.edu.dz/snv/faculte/tc/16.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 L3 bio;HLBI302;pdf;http://blog.univ-angers.fr/sante/files/2013/05/medecine_anatomie_et_physiologie.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 1 M1 bio;HMBI101;pdf;https://www.biotechno.fr/IMG/pdf/5_recommandations_nationales_pedagogiques_BEP_CSS.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 M1 bio;HMBI102;pdf;http://metagraphies.org/Sir-Patrick-Geddes/P-G_scots-college.pdf", db));		
		System.out.println(ProcessRequest("creationcours;Cours 1 M2 bio;HMBI201;pdf;http://nadcou.cegep-rdl.qc.ca/mipec/document/planbio.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 M2 bio;HMBI202;pdf;http://www.fsr.ac.ma/cours/biologie/Fouzia/CoursSVT2-2013.pdf", db));
		System.out.println(ProcessRequest("creationcours;Cours 1 bio;HBI1;pdf;https://www.zoology-uclouvain.be/docs/cours-en-auditoire/SBIOB106_van_doninck.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 bio;HBI2;pdf;https://www.devoir.tn/superieur/Doc/Licence/Universite-de-manouba/Institut-superieur-de-biotechnologie-de-sidi-thabet/Licence-Fondamentale/Semestre-1/cour-biologie-animale-complet(tarek-hajji)[isbst].pdf", db));	
		
		System.out.println(ProcessRequest("creationcours;Cours 1 L1 math;HLMA101;pdf;http://exo7.emath.fr/cours/cours-exo7.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 L1 math;HLMA102;pdf;https://webusers.imj-prg.fr/~marc.hindry/Cours-L1.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 1 L2 math;HLMA201;pdf;http://les.mathematiques.free.fr/pdf/livre.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 L2 math;HLMA202;pdf;http://www.math.sciences.univ-nantes.fr/~robert/Master_Math_robert.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 1 L3 math;HLMA301;pdf;http://www.math.sciences.univ-nantes.fr/~carron/UVPL/coursgeodif.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 L3 math;HLMA302;pdf;https://www.math.univ-toulouse.fr/~jbhu/Nombres-Complexes-L1-def.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 1 M1 math;HMMA101;pdf;http://math.unice.fr/~frapetti/analyse/analyse1_math_2011.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 M1 math;HMMA102;pdf;http://math.unice.fr/~pauly/ca1.pdf", db));		
		System.out.println(ProcessRequest("creationcours;Cours 1 M2 math;HMMA201;pdf;http://math.univ-lille1.fr/~suquet/ens/ICP/Cmd060902.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 M2 math;HMMA202;pdf;https://www.math.u-bordeaux.fr/~creder/Enseignement/Miage02ProbasStats.pdf", db));
		System.out.println(ProcessRequest("creationcours;Cours 1 math;HMA1;pdf;http://math.unice.fr/~delarue/Teaching/CoursL2.pdf", db));	
		System.out.println(ProcessRequest("creationcours;Cours 2 math;HMA2;pdf;http://iml.univ-mrs.fr/~reboul/cours3.pdf", db));	
		
		//Creation QCM
		System.out.println(ProcessRequest("creationqcm;QCM 1 L1 info;HLIN101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L1 info;HLIN101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 L1 info;HLIN102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L1 info;HLIN102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 L2 info;HLIN201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L2 info;HLIN201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 L2 info;HLIN202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L2 info;HLIN202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 L3 info;HLIN301;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L3 info;HLIN301;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 L3 info;HLIN302;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L3 info;HLIN302;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 M1 info;HMIN101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M1 info;HMIN101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 M1 info;HMIN102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M1 info;HMIN102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 M2 info;HMIN201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M2 info;HMIN201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 M2 info;HMIN202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M2 info;HMIN202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 info;HIN1;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 info;HIN1;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 info;HIN2;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 info;HIN2;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		


		System.out.println(ProcessRequest("creationqcm;QCM 1 L1 bio;HLBI101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L1 bio;HLBI101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 L1 bio;HLBI102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L1 bio;HLBI102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 L2 bio;HLBI201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L2 bio;HLBI201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 L2 bio;HLBI202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L2 bio;HLBI202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 L3 bio;HLBI301;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L3 bio;HLBI301;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 L3 bio;HLBI302;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L3 bio;HLBI302;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 M1 bio;HMBI101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M1 bio;HMBI101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 M1 bio;HMBI102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M1 bio;HMBI102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 M2 bio;HMBI201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M2 bio;HMBI201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 M2 bio;HMBI202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M2 bio;HMBI202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 bio;HBI1;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 bio;HBI1;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 bio;HBI2;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 bio;HBI2;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		
		
		
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 L1 math;HLMA101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L1 math;HLMA101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 L1 math;HLMA102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L1 math;HLMA102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L1.com|test1@L1.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 L2 math;HLMA201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L2 math;HLMA201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 L2 math;HLMA202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L2 math;HLMA202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L2.com|test1@L2.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 L3 math;HLMA301;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L3 math;HLMA301;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 L3 math;HLMA302;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 L3 math;HLMA302;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@L3.com|test1@L3.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 M1 math;HMMA101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M1 math;HMMA101;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 M1 math;HMMA102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M1 math;HMMA102;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M1.com|test1@M1.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 M2 math;HMMA201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M2 math;HMMA201;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 M2 math;HMMA202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 M2 math;HMMA202;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;test2@M2.com|test1@M2.com", db));
		
		System.out.println(ProcessRequest("creationqcm;QCM 1 math;HMA1;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 math;HMA1;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		System.out.println(ProcessRequest("creationqcm;QCM 1 math;HMA2;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		System.out.println(ProcessRequest("creationqcm;QCM 2 math;HMA2;Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false;", db));
		*/
		//System.out.println(ProcessRequest("qcmafaire;test1@L2.com", db));
		//System.out.println(ProcessRequest("validerqcm;13;test1@L2.com", db));
		//System.out.println(ProcessRequest("getusers;HLIN101", db));
		
	}

	public static String ProcessRequest(String request, DataBase db) {
		String resultat="";
		String[] value = request.split(";");
		
		switch(value[0]){
		default:
									resultat="Type de requete inconnu";
									break;
			
		case "inscription": 		
									boolean reussi = true;
									try{
										db.insertUtilisateur(new Utilisateur(value[1], value[4], value[3], Boolean.valueOf(value[5]), value[2], Annee.valueOf(value[6])));
									}catch(Exception e)
									{
										reussi = false;
									}
									resultat = "inscription;" + reussi;	
									break;
									
		case "authentification": 
									boolean connecte = true;
									resultat = "authentification";
									try{
										Vector<String> attribute = new Vector<String>();
										attribute.add("_idmail");
										attribute.add("MotDePasse");
										Vector<String> attributeValue = new Vector<String>();
										attributeValue.add(value[1]);
										attributeValue.add(value[2]);
										Vector<Utilisateur> utilisateurs = db.getUtilisateursByAttributes(attribute, attributeValue);
										if(utilisateurs.size()>0)
										{
											Utilisateur utilisateur = utilisateurs.get(0);
											resultat += ";"+connecte+";" + utilisateur.getPrenom() + ";"+utilisateur.getNom()+";"+utilisateur.getEtudiant()+";"+utilisateur.getAnnee().name();
										}
										else
										{
											connecte = false;
										}
									}catch(Exception e)
									{
										connecte = false;
									}
									if(!connecte)
										resultat += ";" + false;
									break;
		case "matiere":
									Vector<String> intitules = new Vector<String>();
									try{
										 intitules = db.getIntituleFromMatiere(Matiere.valueOf(value[1]), Annee.valueOf(value[2]));
									}catch(Exception e)
									{
										
									}
									resultat = "matiere";
									for(int i = 0; i<intitules.size(); i++)
									{
										resultat += ";" + intitules.get(i);
									}
									break;
		case "intitulecours":		
									try{
										Vector<Cours> cours = new Vector<Cours>();
										Vector<String> attribute = new Vector<String>();
										attribute.add("Intitule_id");
										Vector<String> attributeValue = new Vector<String>();
										attributeValue.add(value[1]);
										cours = db.getCoursByAttributes(attribute, attributeValue);
										resultat = "intitule";
										for(int i = 0; i<cours.size(); i++)
										{
											resultat += ";" + cours.get(i).getNom() + "|" + cours.get(i).getFormat().name() + "|" + cours.get(i).getPath();
										}
									}catch(Exception e)
									{
										
									}
									break;
		case "intituleqcm":			Vector<QCM> qcm = new Vector<QCM>();
									try{
									Vector<String> attribute = new Vector<String>();
									attribute.add("Intitule_id");
									Vector<String> attributeValue = new Vector<String>();
									attributeValue.add(value[1]);
									qcm = db.getQCMByAttributes(attribute, attributeValue);
									resultat = "intitule";
									for(int i = 0; i<qcm.size(); i++)
									{
										resultat += ";" + qcm.get(i).getNom() + "|" + qcm.get(i).getId();
									}
									}catch(Exception e)
									{
										
									}
									break;
		case "qcm" :				Vector<QCM> qcmget = new Vector<QCM>();
									try{
											Vector<String> attribute = new Vector<String>();
											attribute.add("_id");
											Vector<String> attributeValue = new Vector<String>();
											attributeValue.add(value[1]);
											qcmget = db.getQCMByAttributes(attribute, attributeValue);
											resultat = "qcm;"+qcmget.get(0).getCode();									
									}catch(Exception e)
									{
			
									}
									break;
									
		case "validerqcm" :			
									boolean validation = true;
									try{
										db.deleteQCMCandidat(Integer.parseInt(value[1]), value[2]);
									}catch(Exception e)
									{
										validation = false;
									}
									resultat = "validerqcm" + validation;
									break;
		case "qcmafaire" :			String sql = "Select QCM._id, Nom, Intitule_id, Code from QCM, QCMCandidat where QCM._id = QCM_id and Utilisateur_id = '" + value[1] + "';";
									try{
									Vector<QCM> qcms = db.executeQueryOnQCMTable(sql);
									resultat = "qcmafaire";
									for(int i = 0; i <qcms.size(); i++)
									{
										resultat += ";" + qcms.get(i).getNom() + "|" + qcms.get(i).getId();
									}
									}catch(Exception e)
									{
										
									}
									break;
		case "creationqcm" :		QCM qcmInsert = new QCM(-1, value[1], value[2], value[3]);

									if(value.length>4)
									{
										String[] qcmCandidat = value[4].split("\\|");

										Vector<String> usersCandidat = new Vector<String>();
										for(int i =0 ; i<qcmCandidat.length; i++)
										{
											usersCandidat.add(qcmCandidat[i]);
										}
										qcmInsert.setDestinataires(usersCandidat);
									}
									boolean insertQCM = true;
									try{
										db.insertQCM(qcmInsert);
									}catch(Exception e)
									{
										insertQCM = false;
									}
									resultat = "creationqcm;"+insertQCM;
									break;
		case "creationcours":
									Cours coursinsert = new Cours(-1, value[2], value[1], Format.valueOf(value[3]), value[4]);
									boolean insertCours = true;
									try{
										db.insertCours(coursinsert);
									}catch(Exception e)
									{
										insertCours = false;
									}
									resultat = "creationcours;" + insertCours;
									break;
		case "getusers":
									String sqlUser = "Select _idMail, Nom, Prenom, Etudiant, MotDePasse, Utilisateur.Annee from Utilisateur, AnneeAuthorisee where (Utilisateur.Annee = AnneeAuthorisee.Annee or AnneeAuthorisee.Annee = 'None') and Intitule_id = '" + value[1] + "';";
									try{
										Vector<Utilisateur> users = db.executeQueryOnUtilisateurTable(sqlUser);
										resultat = "getusers";
										for(int i = 0; i <users.size(); i++)
										{
											resultat += ";" + users.get(i).getIdMail() + "|" + users.get(i).getNom() + "|" + users.get(i).getPrenom();
										}
										}catch(Exception e)
										{
											
										}
										break;
		}
		
		return resultat;
	} 
}
