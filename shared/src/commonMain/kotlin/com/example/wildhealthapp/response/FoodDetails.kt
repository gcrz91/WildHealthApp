package com.example.wildhealthapp.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoodDetails(
    val id: Int,
    @SerialName("ndb_no")
    val ndbNo: Int,
    @SerialName("shrt_desc")
    val shrtDesc: String,
    val water: Double,
    @SerialName("energ_kcal")
    val energKcal: Int,
    val protein: Double,
    @SerialName("lipid_tot")
    val lipidTot: Double,
    val ash: Double,
    val carbohydrt: Double,
    @SerialName("fiber_td")
    val fiberTd: Double,
    @SerialName("sugar_tot")
    val sugarTot: Double,
    val calcium: Double,
    val iron: Double,
    val magnesium: Int,
    val phosphorus: Int,
    val potassium: Int,
    val sodium: Int,
    val zinc: Double,
    val copper: Double,
    val manganese: Double,
    val selenium: Double,
    @SerialName("vit_c")
    val vitC: Double,
    val thiamin: Double,
    val riboflavin: Double,
    val niacin: Double,
    @SerialName("panto_acid")
    val pantoAcid: Double,
    @SerialName("vit_b6")
    val bitB6: Double,
    @SerialName("folate_tot")
    val folateTot: Int,
    @SerialName("folic_acid")
    val folicAcid: Int,
    @SerialName("food_folate")
    val foodFolate: Int,
    @SerialName("folate_dfe")
    val folateDfe: Int,
    @SerialName("choline_tot")
    val cholineTot: Double,
    @SerialName("vit_b12")
    val vitB12: Double,
    @SerialName("vit_a_iu")
    val vitAIu: Double,
    @SerialName("vit_a_rae")
    val vitARae: Double,
    val retinol: Int,
    @SerialName("alpha_carot")
    val alphaCarot: Double,
    @SerialName("beta_carot")
    val betaCarot: Double,
    @SerialName("beta_crypt")
    val betaCrypt: Double,
    val lycopene: Double,
    val lutzea: Double,
    @SerialName("vit_e")
    val vitE: Double,
    @SerialName("vit_d")
    val vitD: Double,
    @SerialName("vit_d_iu")
    val vitDIu: Double,
    @SerialName("vit_k")
    val vitK: Double,
    @SerialName("fa_sat")
    val faSat: Double,
    @SerialName("fa_mono")
    val faMono: Double,
    @SerialName("fa_poly")
    val faPoly: Double,
    val cholestrl: Int,
    @SerialName("gmwt_1")
    val gmwt1: Double,
    @SerialName("gmwt_desc1")
    val gmwtDesc1: String,
    @SerialName("gmwt_2")
    val gmwt2: Double,
    @SerialName("gmwt_desc2")
    val gmwtDesc2: String,
    @SerialName("refuse_pct")
    val refusePct: Double
)
