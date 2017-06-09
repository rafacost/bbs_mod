var e=2.718281828459045235;
var batchsize=5.5;
var grainlb=new Array(6);
var graintype=new Array(6);
var divsrm;
var divcolor;
var divebc;
var volumeunit="Gallons";
var srm=[];
srm[0]='#FFF4D4';
srm[1]='#FFE699';
srm[2]='#FFD878';
srm[3]='#FFCA5A';
srm[4]='#FFBF42';
srm[5]='#FBB123';
srm[6]='#F8A600';
srm[7]='#F39C00';
srm[8]='#EA8F00';
srm[9]='#E58500';
srm[10]='#DE7C00';
srm[11]='#D77200';
srm[12]='#CF6900';
srm[13]='#CB6200';
srm[14]='#C35900';
srm[15]='#BB5100';
srm[16]='#B54C00';
srm[17]='#B04500';
srm[18]='#A63E00';
srm[19]='#A13700';
srm[20]='#9B3200';
srm[21]='#952D00';
srm[22]='#8E2900';
srm[23]='#882300';
srm[24]='#821E00';
srm[25]='#7B1A00';
srm[26]='#771900';
srm[27]='#701400';
srm[28]='#6A0E00';
srm[29]='#660D00';
srm[30]='#5E0B00';
srm[31]='#5A0A02';
srm[32]='#600903';
srm[33]='#520907';
srm[34]='#4C0505';
srm[35]='#470606';
srm[36]='#420607';
srm[37]='#3D0708';
srm[38]='#370607';
srm[39]='#2D0607';
srm[40]='#1F0506';
srm[41]='#000000';
var ingredients=[];
ingredients[0]=
	{
	id:1,name:'--',lovibond:0,ppg:0,mashable:0,category:''
};
ingredients[1]=
	{
	id:2,name:'Flaked Barley',lovibond:2.2,ppg:32,mashable:1,category:'Adjunct'
};
ingredients[2]=
	{
	id:3,name:'Flaked Corn',lovibond:0.5,ppg:40,mashable:1,category:'Adjunct'
};
ingredients[3]=
	{
	id:4,name:'Flaked Oats',lovibond:2.2,ppg:33,mashable:1,category:'Adjunct'
};
ingredients[4]=
	{
	id:5,name:'Flaked Rice',lovibond:0.5,ppg:40,mashable:1,category:'Adjunct'
};
ingredients[5]=
	{
	id:6,name:'Flaked Rye',lovibond:2.8,ppg:36,mashable:1,category:'Adjunct'
};
ingredients[6]=
	{
	id:7,name:'Flaked Wheat',lovibond:2,ppg:34,mashable:1,category:'Adjunct'
};
ingredients[7]=
	{
	id:8,name:'Grits',lovibond:1,ppg:37,mashable:1,category:'Adjunct'
};
ingredients[8]=
	{
	id:9,name:'Rice Hulls',lovibond:0,ppg:0,mashable:1,category:'Adjunct'
};
ingredients[9]=
	{
	id:10,name:'Rolled Oats',lovibond:2.2,ppg:33,mashable:1,category:'Adjunct'
};
ingredients[10]=
	{
	id:11,name:'Torrified Barley',lovibond:2,ppg:36,mashable:1,category:'Adjunct'
};
ingredients[11]=
	{
	id:12,name:'Torrified Wheat',lovibond:2,ppg:36,mashable:1,category:'Adjunct'
};
ingredients[12]=
	{
	id:14,name:'Dry Malt Extract - Amber',lovibond:10,ppg:42,mashable:0,category:'Dry Extract'
};
ingredients[13]=
	{
	id:15,name:'Dry Malt Extract - Dark',lovibond:30,ppg:44,mashable:0,category:'Dry Extract'
};
ingredients[14]=
	{
	id:189,name:'Dry Malt Extract - Extra Light',lovibond:2.5,ppg:42,mashable:0,category:'Dry Extract'
};
ingredients[15]=
	{
	id:13,name:'Dry Malt Extract - Light',lovibond:4,ppg:42,mashable:0,category:'Dry Extract'
};
ingredients[16]=
	{
	id:187,name:'Dry Malt Extract - Munich',lovibond:8,ppg:42,mashable:0,category:'Dry Extract'
};
ingredients[17]=
	{
	id:188,name:'Dry Malt Extract - Pilsen',lovibond:2,ppg:42,mashable:0,category:'Dry Extract'
};
ingredients[18]=
	{
	id:16,name:'Dry Malt Extract - Wheat',lovibond:3,ppg:42,mashable:0,category:'Dry Extract'
};
ingredients[19]=
	{
	id:162,name:'Rice Syrup Solids',lovibond:1,ppg:37,mashable:0,category:'Dry Extract'
};
ingredients[20]=
	{
	id:17,name:'American - Aromatic Malt',lovibond:20,ppg:35,mashable:1,category:'Grain'
};
ingredients[21]=
	{
	id:18,name:'American - Ashbourne Mild',lovibond:5.3,ppg:30,mashable:1,category:'Grain'
};
ingredients[22]=
	{
	id:19,name:'American - Black Barley',lovibond:530,ppg:27,mashable:1,category:'Grain'
};
ingredients[23]=
	{
	id:20,name:'American - Black Malt',lovibond:500,ppg:28,mashable:1,category:'Grain'
};
ingredients[24]=
	{
	id:21,name:'American - Blackprinz',lovibond:500,ppg:36,mashable:1,category:'Grain'
};
ingredients[25]=
	{
	id:22,name:'American - Bonlander Munich',lovibond:10,ppg:36,mashable:1,category:'Grain'
};
ingredients[26]=
	{
	id:23,name:'American - CaraBrown',lovibond:55,ppg:34,mashable:1,category:'Grain'
};
ingredients[27]=
	{
	id:24,name:'American - CaraCrystal Wheat Malt',lovibond:55,ppg:34,mashable:1,category:'Grain'
};
ingredients[28]=
	{
	id:25,name:'American - Caramel / Crystal 10L',lovibond:10,ppg:35,mashable:1,category:'Grain'
};
ingredients[29]=
	{
	id:26,name:'American - Caramel / Crystal 15L',lovibond:15,ppg:35,mashable:1,category:'Grain'
};
ingredients[30]=
	{
	id:27,name:'American - Caramel / Crystal 20L',lovibond:20,ppg:35,mashable:1,category:'Grain'
};
ingredients[31]=
	{
	id:28,name:'American - Caramel / Crystal 30L',lovibond:30,ppg:34,mashable:1,category:'Grain'
};
ingredients[32]=
	{
	id:29,name:'American - Caramel / Crystal 40L',lovibond:40,ppg:34,mashable:1,category:'Grain'
};
ingredients[33]=
	{
	id:30,name:'American - Caramel / Crystal 60L',lovibond:60,ppg:34,mashable:1,category:'Grain'
};
ingredients[34]=
	{
	id:31,name:'American - Caramel / Crystal 75L',lovibond:75,ppg:33,mashable:1,category:'Grain'
};
ingredients[35]=
	{
	id:32,name:'American - Caramel / Crystal 80L',lovibond:80,ppg:33,mashable:1,category:'Grain'
};
ingredients[36]=
	{
	id:33,name:'American - Caramel / Crystal 90L',lovibond:90,ppg:33,mashable:1,category:'Grain'
};
ingredients[37]=
	{
	id:34,name:'American - Caramel / Crystal 120L',lovibond:120,ppg:33,mashable:1,category:'Grain'
};
ingredients[38]=
	{
	id:35,name:'American - Caramel / Crystal 150L',lovibond:150,ppg:33,mashable:1,category:'Grain'
};
ingredients[39]=
	{
	id:36,name:'American - Carapils (Dextrine Malt)',lovibond:1.8,ppg:33,mashable:1,category:'Grain'
};
ingredients[40]=
	{
	id:37,name:'American - Chocolate',lovibond:350,ppg:29,mashable:1,category:'Grain'
};
ingredients[41]=
	{
	id:38,name:'American - Dark Chocolate',lovibond:420,ppg:29,mashable:1,category:'Grain'
};
ingredients[42]=
	{
	id:39,name:'American - Midnight Wheat Malt',lovibond:550,ppg:33,mashable:1,category:'Grain'
};
ingredients[43]=
	{
	id:40,name:'American - Munich - Light 10L',lovibond:10,ppg:33,mashable:1,category:'Grain'
};
ingredients[44]=
	{
	id:41,name:'American - Munich - Dark 20L',lovibond:20,ppg:33,mashable:1,category:'Grain'
};
ingredients[45]=
	{
	id:42,name:'American - Munich - 60L',lovibond:60,ppg:33,mashable:1,category:'Grain'
};
ingredients[46]=
	{
	id:43,name:'American - Pale 2-Row',lovibond:1.8,ppg:37,mashable:1,category:'Grain'
};
ingredients[47]=
	{
	id:44,name:'American - Pale 2-Row - Toasted',lovibond:30,ppg:33,mashable:1,category:'Grain'
};
ingredients[48]=
	{
	id:45,name:'American - Pale 6-Row',lovibond:1.8,ppg:35,mashable:1,category:'Grain'
};
ingredients[49]=
	{
	id:46,name:'American - Pale Ale',lovibond:3.5,ppg:37,mashable:1,category:'Grain'
};
ingredients[50]=
	{
	id:47,name:'American - Pilsner',lovibond:1.8,ppg:37,mashable:1,category:'Grain'
};
ingredients[51]=
	{
	id:48,name:'American - Red Wheat',lovibond:2.5,ppg:38,mashable:1,category:'Grain'
};
ingredients[52]=
	{
	id:49,name:'American - Roasted Barley',lovibond:300,ppg:33,mashable:1,category:'Grain'
};
ingredients[53]=
	{
	id:50,name:'American - Rye',lovibond:3.5,ppg:38,mashable:1,category:'Grain'
};
ingredients[54]=
	{
	id:51,name:'American - Smoked Malt',lovibond:5,ppg:37,mashable:1,category:'Grain'
};
ingredients[55]=
	{
	id:52,name:'American - Special Roast',lovibond:50,ppg:33,mashable:1,category:'Grain'
};
ingredients[56]=
	{
	id:53,name:'American - Victory',lovibond:28,ppg:34,mashable:1,category:'Grain'
};
ingredients[57]=
	{
	id:54,name:'American - Vienna',lovibond:4,ppg:35,mashable:1,category:'Grain'
};
ingredients[58]=
	{
	id:55,name:'American - Wheat',lovibond:1.8,ppg:38,mashable:1,category:'Grain'
};
ingredients[59]=
	{
	id:56,name:'American - White Wheat ',lovibond:2.8,ppg:40,mashable:1,category:'Grain'
};
ingredients[60]=
	{
	id:57,name:'Belgian - Aromatic',lovibond:38,ppg:33,mashable:1,category:'Grain'
};
ingredients[61]=
	{
	id:58,name:'Belgian - Biscuit',lovibond:23,ppg:35,mashable:1,category:'Grain'
};
ingredients[62]=
	{
	id:59,name:'Belgian - Cara 20L',lovibond:22,ppg:34,mashable:1,category:'Grain'
};
ingredients[63]=
	{
	id:60,name:'Belgian - Cara 45L',lovibond:42,ppg:34,mashable:1,category:'Grain'
};
ingredients[64]=
	{
	id:61,name:'Belgian - Caramel Pils',lovibond:8,ppg:34,mashable:1,category:'Grain'
};
ingredients[65]=
	{
	id:62,name:'Belgian - CaraMunich',lovibond:50,ppg:33,mashable:1,category:'Grain'
};
ingredients[66]=
	{
	id:63,name:'Belgian - CaraVienne',lovibond:20,ppg:34,mashable:1,category:'Grain'
};
ingredients[67]=
	{
	id:64,name:'Belgian - Chocolate',lovibond:340,ppg:30,mashable:1,category:'Grain'
};
ingredients[68]=
	{
	id:65,name:'Belgian - De-Bittered Black',lovibond:566,ppg:34,mashable:1,category:'Grain'
};
ingredients[69]=
	{
	id:66,name:'Belgian - Munich',lovibond:6,ppg:38,mashable:1,category:'Grain'
};
ingredients[70]=
	{
	id:67,name:'Belgian - Pale Ale',lovibond:3.4,ppg:38,mashable:1,category:'Grain'
};
ingredients[71]=
	{
	id:68,name:'Belgian - Pilsner',lovibond:1.6,ppg:37,mashable:1,category:'Grain'
};
ingredients[72]=
	{
	id:69,name:'Belgian - Roasted Barley',lovibond:575,ppg:30,mashable:1,category:'Grain'
};
ingredients[73]=
	{
	id:70,name:'Belgian - Special B',lovibond:115,ppg:34,mashable:1,category:'Grain'
};
ingredients[74]=
	{
	id:71,name:'Belgian - Unmalted Wheat',lovibond:2,ppg:36,mashable:1,category:'Grain'
};
ingredients[75]=
	{
	id:72,name:'Belgian - Wheat',lovibond:1.8,ppg:38,mashable:1,category:'Grain'
};
ingredients[76]=
	{
	id:73,name:'Canadian - ESB Malt',lovibond:3.5,ppg:36,mashable:1,category:'Grain'
};
ingredients[77]=
	{
	id:74,name:'Canadian - Honey Malt',lovibond:25,ppg:37,mashable:1,category:'Grain'
};
ingredients[78]=
	{
	id:75,name:'Canadian - Munich Dark',lovibond:32,ppg:34,mashable:1,category:'Grain'
};
ingredients[79]=
	{
	id:76,name:'Canadian - Munich Light',lovibond:10,ppg:34,mashable:1,category:'Grain'
};
ingredients[80]=
	{
	id:77,name:'Canadian - Pale 2-Row',lovibond:1.75,ppg:36,mashable:1,category:'Grain'
};
ingredients[81]=
	{
	id:78,name:'Canadian - Pale Wheat',lovibond:2,ppg:36,mashable:1,category:'Grain'
};
ingredients[82]=
	{
	id:79,name:'German - Abbey Malt ',lovibond:17,ppg:33,mashable:1,category:'Grain'
};
ingredients[83]=
	{
	id:80,name:'German - Acidulated Malt ',lovibond:3.4,ppg:27,mashable:1,category:'Grain'
};
ingredients[84]=
	{
	id:81,name:'German - Bohemian Pilsner',lovibond:1.9,ppg:38,mashable:1,category:'Grain'
};
ingredients[85]=
	{
	id:82,name:'German - CaraAmber',lovibond:23,ppg:34,mashable:1,category:'Grain'
};
ingredients[86]=
	{
	id:83,name:'German - CaraAroma',lovibond:130,ppg:34,mashable:1,category:'Grain'
};
ingredients[87]=
	{
	id:84,name:'German - CaraBelge',lovibond:13.6,ppg:33,mashable:1,category:'Grain'
};
ingredients[88]=
	{
	id:85,name:'German - CaraBohemian',lovibond:75,ppg:33,mashable:1,category:'Grain'
};
ingredients[89]=
	{
	id:86,name:'German - Carafa I',lovibond:340,ppg:32,mashable:1,category:'Grain'
};
ingredients[90]=
	{
	id:87,name:'German - Carafa II',lovibond:425,ppg:32,mashable:1,category:'Grain'
};
ingredients[91]=
	{
	id:88,name:'German - Carafa III',lovibond:535,ppg:32,mashable:1,category:'Grain'
};
ingredients[92]=
	{
	id:89,name:'German - CaraFoam',lovibond:1.8,ppg:37,mashable:1,category:'Grain'
};
ingredients[93]=
	{
	id:90,name:'German - CaraHell',lovibond:11,ppg:34,mashable:1,category:'Grain'
};
ingredients[94]=
	{
	id:91,name:'German - Caramel Pils',lovibond:2.4,ppg:35,mashable:1,category:'Grain'
};
ingredients[95]=
	{
	id:92,name:'German - Caramel Wheat',lovibond:46,ppg:34,mashable:1,category:'Grain'
};
ingredients[96]=
	{
	id:93,name:'German - CaraMunich I',lovibond:39,ppg:34,mashable:1,category:'Grain'
};
ingredients[97]=
	{
	id:94,name:'German - CaraMunich II',lovibond:46,ppg:34,mashable:1,category:'Grain'
};
ingredients[98]=
	{
	id:95,name:'German - CaraMunich III',lovibond:57,ppg:34,mashable:1,category:'Grain'
};
ingredients[99]=
	{
	id:96,name:'German - Carapils',lovibond:1.3,ppg:35,mashable:1,category:'Grain'
};
ingredients[100]=
	{
	id:97,name:'German - CaraRed',lovibond:20,ppg:34,mashable:1,category:'Grain'
};
ingredients[101]=
	{
	id:98,name:'German - Chocolate Rye',lovibond:240,ppg:31,mashable:1,category:'Grain'
};
ingredients[102]=
	{
	id:99,name:'German - Chocolate Wheat',lovibond:413,ppg:31,mashable:1,category:'Grain'
};
ingredients[103]=
	{
	id:100,name:'German - Dark Munich',lovibond:10,ppg:36,mashable:1,category:'Grain'
};
ingredients[104]=
	{
	id:101,name:'German - Dark Wheat',lovibond:6.5,ppg:39,mashable:1,category:'Grain'
};
ingredients[105]=
	{
	id:102,name:'German - De-Husked Caraf I',lovibond:340,ppg:32,mashable:1,category:'Grain'
};
ingredients[106]=
	{
	id:103,name:'German - De-Husked Caraf II',lovibond:418,ppg:32,mashable:1,category:'Grain'
};
ingredients[107]=
	{
	id:104,name:'German - De-Husked Caraf III',lovibond:470,ppg:32,mashable:1,category:'Grain'
};
ingredients[108]=
	{
	id:105,name:'German - Floor-Malted Bohemian Pilsner',lovibond:1.8,ppg:38,mashable:1,category:'Grain'
};
ingredients[109]=
	{
	id:106,name:'German - Floor-Malted Bohemian Pilsner Dk',lovibond:6.5,ppg:38,mashable:1,category:'Grain'
};
ingredients[110]=
	{
	id:107,name:'German - Floor-Malted Bohemian Wheat',lovibond:2,ppg:38,mashable:1,category:'Grain'
};
ingredients[111]=
	{
	id:108,name:'German - Kolsch',lovibond:2,ppg:37,mashable:1,category:'Grain'
};
ingredients[112]=
	{
	id:109,name:'German - Melanoidin',lovibond:25,ppg:37,mashable:1,category:'Grain'
};
ingredients[113]=
	{
	id:110,name:'German - Munich Dark',lovibond:15.5,ppg:37,mashable:1,category:'Grain'
};
ingredients[114]=
	{
	id:111,name:'German - Munich Light',lovibond:6,ppg:37,mashable:1,category:'Grain'
};
ingredients[115]=
	{
	id:112,name:'German - Pale Ale',lovibond:2.3,ppg:39,mashable:1,category:'Grain'
};
ingredients[116]=
	{
	id:113,name:'German - Pale Wheat',lovibond:1.5,ppg:39,mashable:1,category:'Grain'
};
ingredients[117]=
	{
	id:114,name:'German - Pilsner',lovibond:1.6,ppg:38,mashable:1,category:'Grain'
};
ingredients[118]=
	{
	id:115,name:'German - Rye',lovibond:3.5,ppg:38,mashable:1,category:'Grain'
};
ingredients[119]=
	{
	id:116,name:'German - Smoked Malt',lovibond:3,ppg:37,mashable:1,category:'Grain'
};
ingredients[120]=
	{
	id:117,name:'German - Spelt Malt',lovibond:2,ppg:37,mashable:1,category:'Grain'
};
ingredients[121]=
	{
	id:118,name:'German - Vienna',lovibond:4,ppg:37,mashable:1,category:'Grain'
};
ingredients[122]=
	{
	id:119,name:'German - Wheat Malt',lovibond:2,ppg:37,mashable:1,category:'Grain'
};
ingredients[123]=
	{
	id:120,name:'United Kingdom - Amber',lovibond:27,ppg:32,mashable:1,category:'Grain'
};
ingredients[124]=
	{
	id:121,name:'United Kingdom - Black Patent',lovibond:525,ppg:27,mashable:1,category:'Grain'
};
ingredients[125]=
	{
	id:122,name:'United Kingdom - Brown',lovibond:65,ppg:32,mashable:1,category:'Grain'
};
ingredients[126]=
	{
	id:123,name:'United Kingdom - Cara Malt',lovibond:17.5,ppg:35,mashable:1,category:'Grain'
};
ingredients[127]=
	{
	id:124,name:'United Kingdom - Carastan (30/37)',lovibond:34,ppg:35,mashable:1,category:'Grain'
};
ingredients[128]=
	{
	id:125,name:'United Kingdom - Carastan Light (15L)',lovibond:15,ppg:35,mashable:1,category:'Grain'
};
ingredients[129]=
	{
	id:126,name:'United Kingdom - Chocolate',lovibond:425,ppg:34,mashable:1,category:'Grain'
};
ingredients[130]=
	{
	id:127,name:'United Kingdom - Coffee Malt',lovibond:150,ppg:36,mashable:1,category:'Grain'
};
ingredients[131]=
	{
	id:128,name:'United Kingdom - Crystal 15L',lovibond:15,ppg:34,mashable:1,category:'Grain'
};
ingredients[132]=
	{
	id:129,name:'United Kingdom - Crystal 30L',lovibond:30,ppg:34,mashable:1,category:'Grain'
};
ingredients[133]=
	{
	id:130,name:'United Kingdom - Crystal 45L',lovibond:45,ppg:34,mashable:1,category:'Grain'
};
ingredients[134]=
	{
	id:131,name:'United Kingdom - Crystal 50L',lovibond:50,ppg:34,mashable:1,category:'Grain'
};
ingredients[135]=
	{
	id:132,name:'United Kingdom - Crystal 60L',lovibond:60,ppg:34,mashable:1,category:'Grain'
};
ingredients[136]=
	{
	id:133,name:'United Kingdom - Crystal 70L',lovibond:70,ppg:34,mashable:1,category:'Grain'
};
ingredients[137]=
	{
	id:134,name:'United Kingdom - Crystal 90L',lovibond:90,ppg:33,mashable:1,category:'Grain'
};
ingredients[138]=
	{
	id:135,name:'United Kingdom - Crystal 140L',lovibond:140,ppg:33,mashable:1,category:'Grain'
};
ingredients[139]=
	{
	id:136,name:'United Kingdom - Crystal Rye',lovibond:90,ppg:33,mashable:1,category:'Grain'
};
ingredients[140]=
	{
	id:137,name:'United Kingdom - Dextrine Malt',lovibond:1.8,ppg:33,mashable:1,category:'Grain'
};
ingredients[141]=
	{
	id:138,name:'United Kingdom - Dark Crystal 80L',lovibond:80,ppg:33,mashable:1,category:'Grain'
};
ingredients[142]=
	{
	id:139,name:'United Kingdom - Extra Dark Crystal 120L',lovibond:120,ppg:33,mashable:1,category:'Grain'
};
ingredients[143]=
	{
	id:140,name:'United Kingdom - Extra Dark Crystal 160L',lovibond:160,ppg:33,mashable:1,category:'Grain'
};
ingredients[144]=
	{
	id:141,name:'United Kingdom - Golden Naked Oats',lovibond:10,ppg:33,mashable:1,category:'Grain'
};
ingredients[145]=
	{
	id:142,name:'United Kingdom - Golden Promise',lovibond:3,ppg:37,mashable:1,category:'Grain'
};
ingredients[146]=
	{
	id:143,name:'United Kingdom - Halcyon',lovibond:2,ppg:36,mashable:1,category:'Grain'
};
ingredients[147]=
	{
	id:144,name:'United Kingdom - Lager',lovibond:1.4,ppg:38,mashable:1,category:'Grain'
};
ingredients[148]=
	{
	id:145,name:'United Kingdom - Malted Naked Oats',lovibond:1.3,ppg:33,mashable:1,category:'Grain'
};
ingredients[149]=
	{
	id:146,name:'United Kingdom - Maris Otter Pale',lovibond:3.75,ppg:38,mashable:1,category:'Grain'
};
ingredients[150]=
	{
	id:147,name:'United Kingdom - Mild',lovibond:3,ppg:37,mashable:1,category:'Grain'
};
ingredients[151]=
	{
	id:148,name:'United Kingdom - Munich',lovibond:6,ppg:37,mashable:1,category:'Grain'
};
ingredients[152]=
	{
	id:149,name:'United Kingdom - Oat Malt',lovibond:2,ppg:28,mashable:1,category:'Grain'
};
ingredients[153]=
	{
	id:150,name:'United Kingdom - Optic',lovibond:2.1,ppg:38,mashable:1,category:'Grain'
};
ingredients[154]=
	{
	id:151,name:'United Kingdom - Pale 2-Row',lovibond:2.5,ppg:38,mashable:1,category:'Grain'
};
ingredients[155]=
	{
	id:152,name:'United Kingdom - Pale Chocolate',lovibond:207,ppg:33,mashable:1,category:'Grain'
};
ingredients[156]=
	{
	id:153,name:'United Kingdom - Pearl',lovibond:2.1,ppg:37,mashable:1,category:'Grain'
};
ingredients[157]=
	{
	id:154,name:'United Kingdom - Peated Malt',lovibond:2.5,ppg:38,mashable:1,category:'Grain'
};
ingredients[158]=
	{
	id:155,name:'United Kingdom - Pilsen',lovibond:1.8,ppg:36,mashable:1,category:'Grain'
};
ingredients[159]=
	{
	id:156,name:'United Kingdom - Roasted Barley',lovibond:550,ppg:29,mashable:1,category:'Grain'
};
ingredients[160]=
	{
	id:157,name:'United Kingdom - Wheat',lovibond:2,ppg:37,mashable:1,category:'Grain'
};
ingredients[161]=
	{
	id:158,name:'Liquid Malt Extract - Amber',lovibond:10,ppg:35,mashable:0,category:'Liquid Extract'
};
ingredients[162]=
	{
	id:159,name:'Liquid Malt Extract - Dark',lovibond:30,ppg:35,mashable:0,category:'Liquid Extract'
};
ingredients[163]=
	{
	id:190,name:'Liquid Malt Extract - Extra Light',lovibond:2.5,ppg:37,mashable:0,category:'Liquid Extract'
};
ingredients[164]=
	{
	id:160,name:'Liquid Malt Extract - Light',lovibond:4,ppg:35,mashable:0,category:'Liquid Extract'
};
ingredients[165]=
	{
	id:185,name:'Liquid Malt Extract - Munich',lovibond:8,ppg:35,mashable:0,category:'Liquid Extract'
};
ingredients[166]=
	{
	id:186,name:'Liquid Malt Extract - Pilsen',lovibond:2,ppg:35,mashable:0,category:'Liquid Extract'
};
ingredients[167]=
	{
	id:161,name:'Liquid Malt Extract - Wheat',lovibond:3,ppg:35,mashable:0,category:'Liquid Extract'
};
ingredients[168]=
	{
	id:163,name:'Belgian Candi Sugar - Amber/Brown',lovibond:60,ppg:38,mashable:0,category:'Sugar'
};
ingredients[169]=
	{
	id:164,name:'Belgian Candi Sugar - Clear/Blond',lovibond:0,ppg:38,mashable:0,category:'Sugar'
};
ingredients[170]=
	{
	id:165,name:'Belgian Candi Sugar - Dark',lovibond:275,ppg:38,mashable:0,category:'Sugar'
};
ingredients[171]=
	{
	id:166,name:'Belgian Candi Syrup - Amber',lovibond:40,ppg:32,mashable:0,category:'Sugar'
};
ingredients[172]=
	{
	id:167,name:'Belgian Candi Syrup - Clear',lovibond:0,ppg:32,mashable:0,category:'Sugar'
};
ingredients[173]=
	{
	id:168,name:'Belgian Candi Syrup - D2',lovibond:160,ppg:32,mashable:0,category:'Sugar'
};
ingredients[174]=
	{
	id:169,name:'Belgian Candi Syrup - Dark',lovibond:80,ppg:32,mashable:0,category:'Sugar'
};
ingredients[175]=
	{
	id:170,name:'Brown Rice Syrup - Gluten Free',lovibond:2,ppg:44,mashable:0,category:'Sugar'
};
ingredients[176]=
	{
	id:171,name:'Brown Sugar',lovibond:15,ppg:45,mashable:0,category:'Sugar'
};
ingredients[177]=
	{
	id:172,name:'Cane Sugar',lovibond:0,ppg:46,mashable:0,category:'Sugar'
};
ingredients[178]=
	{
	id:173,name:'Corn Sugar - Dextrose ',lovibond:0.5,ppg:46,mashable:0,category:'Sugar'
};
ingredients[179]=
	{
	id:174,name:'Corn Syrup',lovibond:0.5,ppg:37,mashable:0,category:'Sugar'
};
ingredients[180]=
	{
	id:175,name:'Honey ',lovibond:2,ppg:42,mashable:0,category:'Sugar'
};
ingredients[181]=
	{
	id:176,name:'Honey (Buckwheat)',lovibond:2,ppg:42,mashable:0,category:'Sugar'
};
ingredients[182]=
	{
	id:177,name:'Invert Sugar',lovibond:1,ppg:46,mashable:0,category:'Sugar'
};
ingredients[183]=
	{
	id:178,name:'Maple Syrup',lovibond:35,ppg:30,mashable:0,category:'Sugar'
};
ingredients[184]=
	{
	id:179,name:'Milk Sugar',lovibond:1,ppg:35,mashable:0,category:'Sugar'
};
ingredients[185]=
	{
	id:180,name:'Molasses ',lovibond:80,ppg:36,mashable:0,category:'Sugar'
};
ingredients[186]=
	{
	id:181,name:'Soft Candi Sugar - Blond',lovibond:5,ppg:38,mashable:0,category:'Sugar'
};
ingredients[187]=
	{
	id:182,name:'Soft Candi Sugar - Brown',lovibond:60,ppg:38,mashable:0,category:'Sugar'
};
ingredients[188]=
	{
	id:183,name:'White Sorghum Syrup  - Gluten Free',lovibond:1.5,ppg:44,mashable:0,category:'Sugar'
};
ingredients[189]=
	{
	id:184,name:'Turbinado',lovibond:10,ppg:44,mashable:0,category:'Sugar'
};
function switchUnitsToUs()
	{
	$(".volumeunit").html("(Gallons)");
	$(".weightunit").html("Pounds");
	volumeunit="Gallons";
	document.hops.txtbatchsize.value="5.5";
	setCookie("bfmetric","",-1);
	updateAll()
}
function switchUnitsToMetric()
	{
	$(".volumeunit").html("(Liters)");
	$(".weightunit").html("kg");
	volumeunit="Liters";
	document.hops.txtbatchsize.value="21";
	setCookie("bfmetric","metric",(365*3));
	updateAll()
}
function setVars()
	{
	if(document.hops.grainlb1.value=='')
		{
		document.hops.grainlb1.value='0'
	}
	if(document.hops.grainlb2.value=='')
		{
		document.hops.grainlb2.value='0'
	}
	if(document.hops.grainlb3.value=='')
		{
		document.hops.grainlb3.value='0'
	}
	if(document.hops.grainlb4.value=='')
		{
		document.hops.grainlb4.value='0'
	}
	if(document.hops.grainlb5.value=='')
		{
		document.hops.grainlb5.value='0'
	}
	if(document.hops.grainlb6.value=='')
		{
		document.hops.grainlb6.value='0'
	}
	grainlb[0]=document.hops.grainlb1.value;
	grainlb[1]=document.hops.grainlb2.value;
	grainlb[2]=document.hops.grainlb3.value;
	grainlb[3]=document.hops.grainlb4.value;
	grainlb[4]=document.hops.grainlb5.value;
	grainlb[5]=document.hops.grainlb6.value;
	graintype[0]=document.hops.graintype1;
	graintype[1]=document.hops.graintype2;
	graintype[2]=document.hops.graintype3;
	graintype[3]=document.hops.graintype4;
	graintype[4]=document.hops.graintype5;
	graintype[5]=document.hops.graintype6;
	batchsize=document.hops.txtbatchsize.value;
	divsrm=document.getElementById('divsrm');
	divcolor=document.getElementById('divcolor');
	divebc=document.getElementById('divebc')
}
function updateAll()
	{
	if(!checkInput())
		{
		return false
	}
	recalculate()
}
function recalculate()
	{
	if(volumeunit=="Liters")
		{
		batchsize=litersToGallons(batchsize);
		grainlb[0]=kilogramsToPounds(grainlb[0]);
		grainlb[1]=kilogramsToPounds(grainlb[1]);
		grainlb[2]=kilogramsToPounds(grainlb[2]);
		grainlb[3]=kilogramsToPounds(grainlb[3]);
		grainlb[4]=kilogramsToPounds(grainlb[4]);
		grainlb[5]=kilogramsToPounds(grainlb[5])
	}
	var totalMCU=0;
	for(i=0;
	i<6;
	i++)
		{
		var MCU=ingredients[graintype[i].value].lovibond*(grainlb[i]/batchsize);
		totalMCU=totalMCU+MCU
	}
	var newsrm=1.4922*Math.pow(totalMCU,0.6859);
	if(newsrm>=40)
		{
		newsrm=40
	}
	divsrm.innerHTML=rounddecimal(newsrm,2);
	divcolor.style.backgroundColor=srm[rounddecimal(newsrm,0)];
	divebc.innerHTML=rounddecimal(newsrm*1.97,2);
	if(newsrm==0)
		{
		divcolor.style.backgroundColor="#FFFFFF"
	}
}
function checkInput()
	{
	setVars();
	for(i=0;
	i<6;
	i++)
		{
		if(!isNumber(grainlb[i]))
			{
			alert('All values must be numbers.');
			return false
		}
	}
	return true
}
function isNumber(s)
	{
	if(s===null)
		{
		return false
	}
	if(s===0)
		{
		return true
	}
	if(s=='')
		{
		return false
	}
	if(isNaN(s))
		{
		return false
	}
	var i;
	for(i=0;
	i<s.length;
	i++)
		{
		var c=s.charAt(i);
		if(!((c>="0")&&(c<="9"))&&c!='.')
			{
			return false
		}
	}
	return true
}
function rounddecimal(n,places)
	{
	if(n===null)
		{
		return false
	}
	if(n==='')
		{
		return false
	}
	if(isNaN(n))
		{
		return false
	}
	if(places<0)
		{
		return false
	}
	if(places>10)
		{
		return false
	}
	var rounded=Math.round(n*Math.pow(10,places))/Math.pow(10,places);
	var decimalPointPosition=(rounded+"").lastIndexOf(".");
	if(decimalPointPosition==0)
		{
		rounded="0"+rounded;
		decimalPointPosition=1
	}
	if(places!=0)
		{
		decimalPointPosition=(rounded+"").lastIndexOf(".");
		if(decimalPointPosition==-1||decimalPointPosition==rounded.length-1)
			{
			rounded+="."
		}
	}
	decimalPointPosition=(rounded+"").lastIndexOf(".");
	var currentPlaces=((rounded+"").length-1)-decimalPointPosition;
	if(currentPlaces<places)
		{
		for(x=currentPlaces;
		x<places;
		x++)
			{
			rounded+="0"
		}
	}
	return rounded
}
function resetform()
	{
	document.hops.reset();
	setVars();
	recalculate();
	divcolor.style.backgroundColor="#FFFFFF"
}
function litersToGallons(liters)
	{
	liters=parseFloat(liters);
	if(isNaN(liters))
		{
		return false
	}
	return 0.264172052*liters
}
function kilogramsToPounds(kg)
	{
	kg=parseFloat(kg);
	if(isNaN(kg))
		{
		return false
	}
	return 2.20462262*kg
}
function setupDropDowns()
	{
	setVars();
	for(i=0;
	i<6;
	i++)
		{
		dropdown=graintype[i];
		dropdown.options.length=0;
		var optionGroup=document.createElement('optgroup');
		var strLastGroup="";
		for(z=0;
		z<ingredients.length;
		z++)
			{
			if(strLastGroup!=ingredients[z].category)
				{
				optionGroup=document.createElement('optgroup');
				optionGroup.label=ingredients[z].category;
				strLastGroup=ingredients[z].category
			}
			var optionItem=document.createElement('option');
			optionItem.value=z;
			optionItem.innerHTML=ingredients[z].name;
			optionGroup.appendChild(optionItem);
			dropdown.appendChild(optionGroup)
		}
	}
}
