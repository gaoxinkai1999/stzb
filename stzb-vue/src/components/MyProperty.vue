<template>
  <el-button  @click="dialogVisible = true">设置</el-button>
  <el-dialog
      v-model="dialogVisible"
      title="Tips"
      width="30%"
  >
    <div>
      <span class="demonstration">等级  {{ property.等级 }}</span>

      <el-slider :min="1" :max="50" @input='change();a()' v-model="property.等级"/>
    </div>
    <div>
      <span class="demonstration">攻击  {{ property.攻击 }}</span>

      <el-slider @input="b" :min=基础属性.攻击 :max=property.攻击+可加点数 @change="change" v-model="property.攻击"/>
    </div>
    <div>
      <span class="demonstration">谋略  {{ property.谋略 }}</span>
      <el-slider @input="b" :min=基础属性.谋略 :max=property.谋略+可加点数 @change="change" v-model="property.谋略"/>
    </div>
    <div>
      <span class="demonstration">防御  {{ property.防御 }}</span>
      <el-slider @input="b" :min=基础属性.防御 :max=property.防御+可加点数 @change="change" v-model="property.防御"/>
    </div>
    <div>
      <span class="demonstration">速度  {{ property.速度 }}</span>
      <el-slider @input="b" :min=基础属性.速度 :max=property.速度+可加点数 @change=change v-model="property.速度"/>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "MyProperty",
  data() {
    return {
      property: {
        等级: '',
        攻击: '',
        谋略: '',
        防御: '',
        速度: ''
      },
      可加点数: '',
      总加点数: '',
      hero: '',
      基础属性: {
        攻击: '',
        谋略: '',
        防御: '',
        速度: ''
      },
      dialogVisible: false
    }
  },
  props: ['propertys', 'name'],
  emits: ['update:propertys'],
  methods: {
    change() {
      this.$emit('update:propertys', this.property)

    },

    // 获取武将信息
    getheroinfo(newname) {
      this.$http({
        url: 'getheroinfo',
        method: 'get',
        params: {
          'name': newname
        }
      }).then(res => {
        console.log(res.data)
        this.hero = res.data

      })
    },
    //实时修改当前可加点数、各项属性基础值
    a() {
      let num = 0

      if (this.hero.sex === '男') {
        console.log(this.hero.sex)
        num = parseInt(this.property.等级 / 10) * 10
      } else if (this.hero.sex === '女') {
        num = parseInt(this.property.等级 / 10) * 15
      }

      this.可加点数 = num
      this.总加点数 = num

      this.基础属性.攻击 = (this.hero.攻击成长 * 100 * (this.property.等级 - 1) + this.hero.攻击基础 * 100) / 100
      this.property.攻击 = this.基础属性.攻击

      this.基础属性.谋略 = (this.hero.谋略成长 * 100 * (this.property.等级 - 1) + this.hero.谋略基础 * 100) / 100
      this.property.谋略 = this.基础属性.谋略

      this.基础属性.防御 = (this.hero.防御成长 * 100 * (this.property.等级 - 1) + this.hero.防御基础 * 100) / 100
      this.property.防御 = this.基础属性.防御

      this.基础属性.速度 = (this.hero.速度成长 * 100 * (this.property.等级 - 1) + this.hero.速度基础 * 100) / 100
      this.property.速度 = this.基础属性.速度
    },
    b() {
      this.可加点数 = (this.基础属性.攻击 + this.基础属性.防御 + this.基础属性.谋略 + this.基础属性.速度 + this.总加点数) -
          (this.property.攻击 + this.property.谋略 + this.property.速度 + this.property.防御)
    }
  },
  watch: {
    name: {
      handler() {
        console.log(this.name)
        this.getheroinfo(this.name)
      },
      // 代表在wacth里声明了firstName这个方法之后立即先去执行handler方法
      immediate: true,


    }
  }
}
</script>

<style scoped>
span {
  font-size: 14px;
  color: var(--el-text-color-secondary);
  line-height: 44px;
  flex: 1;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 0;
}

div {
  width: 60%;
  margin-top: 20px;
  display: flex;
  align-items: center;
}

el-slider {
  margin-top: 0;
  margin-left: 22px;
  width: auto;
}
</style>
