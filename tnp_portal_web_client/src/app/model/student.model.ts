import { Job } from "./job.model"

export class Student{
    id: string
    name: string
    email: string
    branch: string
    password: string
    rollNo: number
    cgpa: number
    ssc: number
    hsc: number
    quantitative_score: number
    logical_reasoning_score: number
    english_prof_score: number
    automata_pro_score: number
    computer_science_score: number
    internships: number
    backlogs: number
    projects: number
    placed: boolean
    appliedJobs: Job[]
}